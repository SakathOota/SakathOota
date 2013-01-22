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
 * @since Jan 22, 2013 5:06:57 PM
 */
public class FBAuthTest extends TestBase {

	@Test
	public void authenticateUser(){
		resource.path("fbauth/login").get(ClientResponse.class);
	}
}
