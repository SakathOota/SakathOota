/**
 * 
 */
package com.sakathOota.tests;

import org.testng.annotations.Test;

import com.sakathOota.tests.commons.TestBase;
import com.sakathOota.tests.commons.TestObjectsMother;

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
}
