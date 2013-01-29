package com.sakathOota.tests;

import com.sakathOota.tests.commons.TestBase;
import com.sakathOota.tests.commons.TestObjectsMother;
import com.sun.jersey.api.client.ClientResponse;
import com.whiteSpace.domain.common.types.User;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/17/13
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserTest extends TestBase {

    @Test
    public void createUserTest(){
         resource.path("users").entity(TestObjectsMother.getNewUserTestObject()).post();
    }
    
    @Test
    public void getUserByFBIdTest(){
    	resource.path("users/1234").queryParam("idType", "FACEBOOK_ID").get(ClientResponse.class);
    }
    
    @Test
    public void getLatestCheckin(){
    	resource.path("users/100005009113735/fb/checkins/latest").queryParam("idType", "FACEBOOK_ID").get(ClientResponse.class);
    }
    
}
