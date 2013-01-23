/**
 * 
 */
package com.whiteSpace.resource.impl;

import java.net.MalformedURLException;
import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.domain.common.types.UserIdType;
import com.whiteSpace.resource.iface.FBCredentialsController;
import com.whiteSpace.ws.commons.FB2NativeMapper;

/**
 * @author Shivakumar N
 *
 * @since Jan 22, 2013 12:03:13 AM
 */
public class FBCredentailsControllerImpl implements FBCredentialsController{
	
	private FBDataAccess fbDataAccess;
	
	@Autowired
    private UserDataDAO userDataDAO;

	private OAuth2Operations oauthOperations;
	private OAuth2Parameters params;
	private String basePath;
	
	public FBCredentailsControllerImpl(FBDataAccess fbDataAccess, String basePath){
		this.fbDataAccess = fbDataAccess;
		oauthOperations = fbDataAccess.getConnectionFactory().getOAuthOperations();
		params = new OAuth2Parameters();
		params.setScope("email,user_birthday,user_likes,user_status,user_checkins,user_location");
		this.basePath = basePath;
	}

	
	@Override
	public Response loginRedirectToFB(UriInfo uriInfo) {
		try {
			params.setRedirectUri(URI.create(uriInfo.getBaseUri().toURL().toString() + basePath).toURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String authorizeUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, params);
		return Response.seeOther(URI.create(authorizeUrl)).build();
	}
	
	@Override
	public Response redirectCallback(String authorizationCode, UriInfo uriInfo) {
		AccessGrant accessGrant = null;
		try {
			accessGrant = oauthOperations.exchangeForAccess(authorizationCode, URI.create(uriInfo.getBaseUri().toURL().toString() + basePath).toURL().toString(), null);
		
			System.err.println("Acccccesss (**************" + accessGrant.getAccessToken());
			
			//Check whether user exists or not?
			Connection<Facebook> connection = fbDataAccess.getConnectionFactory().createConnection(accessGrant);
			Facebook facebook = connection.getApi();
			FacebookProfile userProfile = facebook.userOperations().getUserProfile();
			Long fbId = Long.parseLong(userProfile.getId());
			if(userDataDAO.getUserByFBId(fbId) != null){
				userDataDAO.updateAccessTokenByFBId(fbId, accessGrant.getAccessToken(), accessGrant.getExpireTime());
			}
			else {
				User newUser = FB2NativeMapper.mapUser(userProfile, accessGrant.getAccessToken(), accessGrant.getExpireTime());
				userDataDAO.createUser(newUser);
			}
			URI url = URI.create(uriInfo.getBaseUri().toURL().toString() + "web/user/" + fbId +"?idType="+UserIdType.FACEBOOK_ID);
			return Response.seeOther(url).build();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Long expiryTimeCalculator(Long expiryTime){
		final Long MILLIE_SEC_IN_MIN = 60*1000L; // Assming 5 min delay
		return System.currentTimeMillis() + expiryTime - 5*MILLIE_SEC_IN_MIN;
	}
}
