package com.whiteSpace.resource.impl;

import com.whiteSpace.resource.delegators.UserFacebookOperations;
import com.whiteSpace.resource.iface.UserResource;
import com.whiteSpace.ws.commons.ResponseHandler;
import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.domain.common.types.UserIdType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Checkin;

import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/15/13
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserDataDAO userDataDAO;
    private UserFacebookOperations userFacebookOperations;
    private FBDataAccess fbDataAccess;
    
    public UserFacebookOperations getUserFacebookOperations() {
		return userFacebookOperations;
	}

	public void setUserFacebookOperations(
			UserFacebookOperations userFacebookOperations) {
		this.userFacebookOperations = userFacebookOperations;
	}
	
    public FBDataAccess getFbDataAccess() {
		return fbDataAccess;
	}

	public void setFbDataAccess(FBDataAccess fbDataAccess) {
		this.fbDataAccess = fbDataAccess;
	}

	@Override
    public Response getUser(String id, String idType) {
    	//Add validations code 
    	User user = null;
    	switch (UserIdType.fromValue(idType.toUpperCase())) {
			case FACEBOOK_ID :
				user = userDataDAO.getUserByFBId(Long.parseLong(id));
				break;
				
			default :
				break;
		}
        return Response.ok(user).build();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response createUser(User user) {
        //FIXME: write validation code
    	user = userDataDAO.createUser(user);
        return ResponseHandler.getOKResponse(user);
    }

	@Override
	public Response getLatestCheckin(String id, String idType) {
		//FIXME: write validation code
		Location checkin = null;
    	switch (UserIdType.fromValue(idType.toUpperCase())) {
			case FACEBOOK_ID :
				checkin = userFacebookOperations.getLatestCheckin(id);
				break;
				
			default :
				break;
		}
    	
		return ResponseHandler.getOKResponse(checkin);
	}
}
