/**
 * 
 */
package com.whiteSpace.resource.impl;

import javax.ws.rs.core.Response;

import com.whiteSpace.resource.iface.FBRealTimeNotificationResource;
import com.whiteSpace.resource.iface.UserResource;
import com.whiteSpace.resource.json.types.Notification;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.String;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 10:11:33 PM
 */
public class FBRealTimeNotificationResourceImpl implements FBRealTimeNotificationResource {
	private static final Logger logger = Logger.getLogger(FBRealTimeNotificationResourceImpl.class);

    @Autowired
    private UserResource userResource;
    
    private FBDataAccess fbDataAccess;
    
	public void setFbDataAccess(FBDataAccess fbDataAccess) {
		this.fbDataAccess = fbDataAccess;
	}


	public Response postCallBackUrl(Notification notification) {

		return null;
	}

	
	public Response getCallBackUrl(String verifyToken, String challenge,
			String mode) {
		logger.info(verifyToken);
		//FIXME: add logic to verify the token
		return Response.ok(challenge).build();
	}

}
