/**
 * 
 */
package com.sakathOota.resource.iface;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 10:10:34 PM
 */

@Path("/fb")
public interface FBRealTimeNotificationDAO {

	@GET
	public Response getCallBackUrl(@QueryParam("hub.verify_token") String verifyToken,
			@QueryParam("hub.challenge") String challenge,
			@QueryParam("hub.mode") String mode);
	
	@POST
	@Path("/")
	public Response postCallBackUrl(String data);
}
