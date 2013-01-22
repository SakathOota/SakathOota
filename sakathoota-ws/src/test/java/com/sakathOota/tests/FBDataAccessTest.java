package com.sakathOota.tests;

import com.sakathOota.tests.commons.TestBase;
import com.sakathOota.tests.commons.TestObjectsMother;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/21/13
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class FBDataAccessTest extends TestBase {

    @Test
    public void getUserProfileData(){
        resource.path("fbData/AAAGNxAItAjIBADIt3ymGdDbreNF33uiI5NzrEAKGxez1tl3AFPPzRqCAKZCytBT1ZBg9goEQNZAw2ZCUQho80RYoYQCFmeyxb6DeeC2PnwZDZD").get(ClientResponse.class);
    }
}
