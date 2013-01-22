/**
 * 
 */
package com.whiteSpace.resource.iface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Shivakumar N
 *
 * @since Jan 21, 2013 11:59:11 PM
 */
@Path("/fbauth")
public interface FBCredentialsController {
	
	@GET
	@Path("/login")
	public Response loginRedirectToFB(@Context UriInfo uriInfo);
	
	@GET
	@Path("/redirect")
	public Response redirectCallbackl(@QueryParam("code") String code, @Context UriInfo uriInfo);
	
}
