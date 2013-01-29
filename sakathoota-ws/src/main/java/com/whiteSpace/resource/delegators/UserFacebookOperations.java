/**
 * 
 */
package com.whiteSpace.resource.delegators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Checkin;

import com.whiteSpace.da.iface.LocationDAO;
import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.resource.impl.FBDataAccess;
import com.whiteSpace.ws.commons.FB2NativeMapper;

/**
 * @author Shivakumar N
 *
 * @since Jan 29, 2013 7:06:44 PM
 */
public class UserFacebookOperations {
	
	 @Autowired
	 private UserDataDAO userDataDAO;
	 
	 @Autowired
	 private LocationDAO locationDAO;
	 
	 private FBDataAccess fbDataAccess;
	
	public FBDataAccess getFbDataAccess() {
		return fbDataAccess;
	}

	public void setFbDataAccess(FBDataAccess fbDataAccess) {
		this.fbDataAccess = fbDataAccess;
	}

	public Location getLatestCheckin(String fbUserId){
		User user = userDataDAO.getUserByFBId(Long.parseLong(fbUserId));
		List<Checkin> checkins = fbDataAccess.getUserCheckins(user.getFbAccessToken());
		checkAndSaveToLocal(checkins);
		if (checkins.size() > 0) {
			Checkin latestCheckin = checkins.get(0);
			for (Checkin checkin : checkins) {
				if(latestCheckin.getCreatedTime().compareTo(checkin.getCreatedTime()) < 0){
					latestCheckin = checkin;
				}
			}
			Location location = FB2NativeMapper.mapLocation(latestCheckin);
			location.setUser(user);
			return location;
		}
		return null;
	}
	
	private void checkAndSaveToLocal(List<Checkin> checkins){
		//FIXME: Implement in efficient way(Add bulk API)
		for (Checkin checkin : checkins) {
			if(locationDAO.getLocationByFBLocationId(Long.parseLong(checkin.getPlace().getId())) == null){
				locationDAO.createLocation(FB2NativeMapper.mapLocation(checkin));
			}
		}
	}
}
