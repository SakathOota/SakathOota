/**
 * 
 */
package com.whiteSpace.resource.impl;

import java.util.List;

import org.springframework.social.facebook.api.Checkin;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;

/**
 * @author Shivakumar N
 *
 * @since Jan 22, 2013 4:42:50 PM
 */
public class FBDataAccess {
	private FacebookConnectionFactory connectionFactory;

	public FacebookConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(FacebookConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	
	public void getUserLatestCheckin(String accessToken){
		Facebook facebook = connectionFactory.createConnection(new AccessGrant(accessToken)).getApi();
		List<Checkin> checkins = facebook.placesOperations().getCheckins();
		for (Checkin checkin : checkins) {
			System.out.println(checkin.getPlace().getName());
		}
		
	}
}
