package com.sakathOota.tests.commons;

import com.whiteSpace.domain.common.types.FoodPreference;
import com.whiteSpace.domain.common.types.Gender;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.resource.json.types.Entry;
import com.whiteSpace.resource.json.types.FBNotification;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/20/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestObjectsMother {

    public static User getNewUserTestObject(){
        User user = new User();
        String sysTime = "" + System.currentTimeMillis();
        user.setEmail("something"+ sysTime +"@nothnoing.com");
        user.setDateOfBirth(new Date());
        user.setFacebookId(1234L);
        user.setFoodPref(FoodPreference.NON_VEG);
        user.setName("something" + sysTime);
        user.setGender(Gender.MALE);
        return user;
    }

    public static FBNotification getNewNotificationObject(){
        FBNotification notification = new FBNotification();
        notification.setObject("user");

        Entry entry1 = new Entry();
        entry1.setId(123L);
        entry1.setTime(345L);
        entry1.setUid(232L);

        notification.getEntry().add(entry1);
        //entry1.setChanged_fields();
        return notification;
    }
}
