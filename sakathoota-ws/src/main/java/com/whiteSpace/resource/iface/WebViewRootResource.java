/**
 * 
 */
package com.whiteSpace.resource.iface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;

/**
 * @author Shivakumar N
 * 
 * @since Jan 21, 2013 11:14:58 PM
 */
@Path("/web")
public interface WebViewRootResource {

	@GET
	@Produces("text/html")
	public Response index();
	
	@GET
	@Path("/user/{id}")
	@Produces("text/html")
	public Response showUser(@PathParam("id") String id, @QueryParam("idType") String idType, @Context Request request);

}
