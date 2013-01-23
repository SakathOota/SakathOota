/**
 * 
 */
package com.whiteSpace.resource.iface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author Shivakumar N
 *
 * @since Jan 23, 2013 2:13:15 PM
 */
@Path("txtweb")
public interface TxtWebResource {
	
	@GET
	@Path("/register")
	public Response register(@QueryParam("txtweb-mobile") String encodedNumber, @QueryParam("txtweb-message") String message);
	
}
