/**
 * 
 */
package com.sakathOota.tests;

import org.testng.annotations.Test;

import com.sakathOota.tests.commons.TestBase;
import com.sakathOota.tests.commons.TestObjectsMother;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author Shivakumar N
 *
 * @since Jan 28, 2013 6:27:25 PM
 */
public class LocationTest extends TestBase {

	@Test
	public void createLocationTest(){
		resource.path("locations").entity(TestObjectsMother.getNewLocationObject()).post();
	}
	
	@Test
	public void getLocationByPartialName(){
		resource.path("locations").queryParam("q", "jun").get(ClientResponse.class);
	}
}
