/**
 * 
 */
package com.whiteSpace.ws.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.social.facebook.api.Checkin;
import org.springframework.social.facebook.api.FacebookProfile;

import com.whiteSpace.domain.common.types.FoodPreference;
import com.whiteSpace.domain.common.types.Gender;
import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.domain.common.types.Locations;
import com.whiteSpace.domain.common.types.Notification;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.resource.json.types.FBNotification;

/**
 * @author Shivakumar N
 *
 * @since Jan 23, 2013 12:14:09 PM
 */
public class FB2NativeMapper {

	public static User mapUser(FacebookProfile userProfile, String accessToken, Long expiresOn){
		User user = new User();
		
		user.setEmail(userProfile.getEmail());
		user.setFacebookId(Long.parseLong(userProfile.getId()));
		user.setName(userProfile.getName());
		user.setDateOfBirth(getBirthDateDate(userProfile.getBirthday()));
		user.setGender(getGender(userProfile.getGender()));
		user.setFbAccessToken(accessToken);
		user.setFbAccessTokenExpires_On(expiresOn);
		user.setFoodPref(FoodPreference.NOT_SPECIFIED);
		return user;	
	}
	
	@Deprecated
	public static Notification getFBNotification(FBNotification fbNotification){
		Notification notification = new Notification();
		notification.setData(fbNotification.getEntry().get(0).getChanged_fields().get(0));
		return notification;
	}
	
	public static Location mapLocation(Checkin checkin) {
		Location location = new Location();
		location.setFbLocationId(Long.parseLong(checkin.getPlace().getId()));
		location.setName(checkin.getPlace().getName());
		location.setLongitude(checkin.getPlace().getLocation().getLongitude());
		location.setLatitude(checkin.getPlace().getLocation().getLatitude());
		location.setStreet(checkin.getPlace().getLocation().getStreet());
		location.setCity(checkin.getPlace().getLocation().getCity());
		return location;
	}
	
	private static Date getBirthDateDate(String dateString){
		try {//08/13/1989
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Gender getGender(String genderString){
		if(genderString.toUpperCase().equals("MALE")){
			return Gender.MALE;
		} else if(genderString.toUpperCase().equals("FEMALE")){
			return Gender.FEMALE;
		}
		return Gender.NOT_SPECIFIED;
	}
}
