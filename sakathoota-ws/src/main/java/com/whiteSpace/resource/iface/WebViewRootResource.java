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
import javax.ws.rs.Produces;
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

}
