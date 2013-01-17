/**
 * 
 */
package com.sakathOota.resource.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import com.sakathOota.resource.iface.FBRealTimeNotificationDAO;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 10:11:33 PM
 */
public class FBRealTimeNotificationDAOImpl implements FBRealTimeNotificationDAO{
	private static final Logger logger = Logger.getLogger(FBRealTimeNotificationDAOImpl.class);
	
	public Response postCallBackUrl(String data) {
		logger.info(data);
		return null;
	}

	
	public Response getCallBackUrl(String verifyToken, String challenge,
			String mode) {
		logger.info(verifyToken);
		//FIXME: add logic to verify the token
		return Response.ok(challenge).build();
	}

}
