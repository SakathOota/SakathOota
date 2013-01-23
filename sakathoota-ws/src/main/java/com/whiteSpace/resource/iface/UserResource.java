package com.whiteSpace.resource.iface;

import com.whiteSpace.domain.common.types.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/15/13
 * Time: 9:01 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("users")
public interface UserResource {

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") String id, @QueryParam("idType") String idType);

    @POST
    public Response createUser(User user);
    
}
