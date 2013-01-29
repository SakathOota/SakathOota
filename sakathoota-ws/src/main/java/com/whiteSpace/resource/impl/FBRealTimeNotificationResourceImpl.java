/**
 * 
 */
package com.whiteSpace.resource.impl;

import javax.ws.rs.core.Response;

import com.whiteSpace.da.iface.TxtWebDAO;
import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.domain.common.types.Notification;
import com.whiteSpace.domain.common.types.TxtWebPhone;
import com.whiteSpace.resource.delegators.UserFacebookOperations;
import com.whiteSpace.resource.iface.FBRealTimeNotificationResource;
import com.whiteSpace.resource.json.types.FBNotification;
import com.whiteSpace.ws.commons.TxtWebPush;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.String;
import java.util.List;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 10:11:33 PM
 */
public class FBRealTimeNotificationResourceImpl implements FBRealTimeNotificationResource {
	private static final Logger logger = Logger.getLogger(FBRealTimeNotificationResourceImpl.class);

	@Autowired
	private TxtWebDAO txtWebDAO;
	
	private UserFacebookOperations userFacebookOperations;

	public void setUserFacebookOperations(UserFacebookOperations userFacebookOperations) {
		this.userFacebookOperations = userFacebookOperations;
	}

	public Response postCallBackUrl(FBNotification fbNotification) {
		Notification notification = getNotificationData(fbNotification);
		
		//FIXME: Remove sending msg
		TxtWebPush txtWebPush = new TxtWebPush();
		List<TxtWebPhone> phones = txtWebDAO.getActivePhones();
		for (TxtWebPhone txtWebPhone : phones) {
			
			txtWebPush.processRequest(notification, txtWebPhone.getEncodedNumber());
		}
		return null;
	}

	
	public Response getCallBackUrl(String verifyToken, String challenge,
			String mode) {
		logger.info(verifyToken);
		//FIXME: add logic to verify the token
		return Response.ok(challenge).build();
	}
	
	private Notification getNotificationData(FBNotification fbNotification){
		Notification notification = new Notification();
		String changedFiled = null;
		if(fbNotification.getEntry().size() == 1){
			changedFiled = fbNotification.getEntry().get(0).getChanged_fields().get(0);
		}
		if(changedFiled.equals("checkins")){
			Location location = userFacebookOperations.getLatestCheckin(fbNotification.getEntry().get(0).getUid().toString());
			notification.setData(location.getUser().getName() + " cheked in to " + location.getName() +"," + location.getStreet() + "," + location.getCity());
			logger.info("Sending data*******" + notification.getData());
		}
		return notification;
	}
}
