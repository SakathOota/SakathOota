/**
 * 
 */
package com.whiteSpace.ws.commons;

import javax.ws.rs.core.Response;

/**
 * @author Shivakumar N
 *
 * @since Jan 28, 2013 6:20:01 PM
 */
public class ResponseHandler {

	public static Response getOKResponse(Object object){
		if(object == null){
			//FIXME: throw exception
		}
		return Response.ok(object).build();
	}
}