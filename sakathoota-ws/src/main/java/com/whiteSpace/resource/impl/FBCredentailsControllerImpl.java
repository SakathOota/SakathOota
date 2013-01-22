/**
 * 
 */
package com.whiteSpace.resource.impl;

import java.net.MalformedURLException;
import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.resource.iface.FBCredentialsController;

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
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.err.println("Acccccesss (**************" + accessGrant.getAccessToken());
		
		//Check whether user exists or not?
		
		
		
		//Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
		//connectionFactory.createConnection(null);
		ConnectionData connectionData;
		//Facebook facebook = connection.getApi();
		
		return null;
	}
}
