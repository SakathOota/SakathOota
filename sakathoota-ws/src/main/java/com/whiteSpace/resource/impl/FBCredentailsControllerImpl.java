/**
 * 
 */
package com.whiteSpace.resource.impl;

import java.net.MalformedURLException;
import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

import com.whiteSpace.resource.iface.FBCredentialsController;

/**
 * @author Shivakumar N
 *
 * @since Jan 22, 2013 12:03:13 AM
 */
public class FBCredentailsControllerImpl implements FBCredentialsController{
	
	private FacebookConnectionFactory connectionFactory;
	private OAuth2Operations oauthOperations;
	private OAuth2Parameters params;
	private String basePath;
	
	public FBCredentailsControllerImpl(FacebookConnectionFactory connectionFactory, String basePath){
		this.connectionFactory = connectionFactory;
		oauthOperations = connectionFactory.getOAuthOperations();
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
	public Response redirectCallbackl(String authorizationCode, UriInfo uriInfo) {
		AccessGrant accessGrant = null;
		try {
			accessGrant = oauthOperations.exchangeForAccess(authorizationCode, URI.create(uriInfo.getBaseUri().toURL().toString() + basePath).toURL().toString(), null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.err.println("Acccccesss (**************" + accessGrant.getAccessToken());
		
		Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
		
		
		return null;
	}
}
