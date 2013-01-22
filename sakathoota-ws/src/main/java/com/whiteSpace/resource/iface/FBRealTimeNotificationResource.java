/**
 * 
 */
package com.whiteSpace.resource.iface;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.whiteSpace.resource.json.types.Notification;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 10:10:34 PM
 */

@Path("/fb")
public interface FBRealTimeNotificationResource {

	@GET
	public Response getCallBackUrl(@QueryParam("hub.verify_token") String verifyToken,
			@QueryParam("hub.challenge") String challenge,
			@QueryParam("hub.mode") String mode);
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response postCallBackUrl(Notification notification);
}
