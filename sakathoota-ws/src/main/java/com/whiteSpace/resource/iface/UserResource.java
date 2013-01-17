package com.whiteSpace.resource.iface;

import com.whiteSpace.domain.common.types.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public Response getUser(@PathParam("id") String id);

    @POST
    public Response createUser(User user);

}
