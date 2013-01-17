/**
 * 
 */
package com.sakathOota.tests;

import org.testng.annotations.Test;

import com.sakathOota.tests.commons.TestBase;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 11:00:30 PM
 */
public class FBNotificationsTest extends TestBase{

	@Test
	public void getCallTest(){
		resource.path("fb").queryParam("hub.mode", "abc").
		queryParam("hub.verify_token", "xyz").queryParam("hub.challenge", "pqr").get(ClientResponse.class);
	}
	
	@Test
	public void postCallTest(){
		resource.path("fb").post("sdcjsnuv");
		
	}
}
