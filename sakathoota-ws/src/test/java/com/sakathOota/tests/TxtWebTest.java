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
 * @since Jan 28, 2013 8:17:38 PM
 */
public class TxtWebTest extends TestBase{
	@Test
	public void registerTxtWebMobileTest(){
		resource.path("txtweb/register").queryParam("txtweb-mobile", "adb").queryParam("txtweb-message", "ads").get(ClientResponse.class);
	}
}
