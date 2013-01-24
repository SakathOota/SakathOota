package com.whiteSpace.ws.commons;

import com.whiteSpace.domain.common.types.FoodPreference;
import com.whiteSpace.domain.common.types.Gender;
import com.whiteSpace.domain.common.types.Notification;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.resource.json.types.FBNotification;
import fi.foyt.foursquare.api.entities.CompleteUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 1/24/13
 * Time: 12:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class FS2NativeMapper {
    public static User mapUser(CompleteUser userProfile, String accessToken){
        User user = new User();

        user.setEmail(null);
        user.setFoursquareId(Long.parseLong(userProfile.getId()));
        user.setName(userProfile.getFirstName()+userProfile.getLastName());
        user.setDateOfBirth(null);
        user.setGender(getGender(userProfile.getGender()));
        user.setFsAccessToken(accessToken);
        user.setFbAccessTokenExpires_On(null);
        user.setFoodPref(FoodPreference.NOT_SPECIFIED);
        return user;
    }

    public static Notification getFBNotification(FBNotification fbNotification){
        Notification notification = new Notification();
        notification.setData(fbNotification.getEntry().get(0).getChanged_fields().get(0));

        return notification;

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
