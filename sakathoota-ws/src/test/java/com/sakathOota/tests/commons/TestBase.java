/**
 * 
 */
package com.sakathOota.tests.commons;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.sun.jersey.api.client.WebResource;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 10:52:24 PM
 */
@ContextConfiguration(locations ={"classpath*:ws-test-beans.xml"} )
public class TestBase extends AbstractTestNGSpringContextTests{
	
public static WebResource resource;
	
	static{
		ResourceProvider  provider = new ResourceProvider();
		resource = provider.getResource();
	}
}
