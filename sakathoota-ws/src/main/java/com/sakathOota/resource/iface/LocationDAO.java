package com.sakathOota.resource.iface;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/15/13
 * Time: 8:47 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("location")
public interface LocationDAO {

    @Path("/{id}")
    @GET
    public Response getLocation(@PathParam("id") String id);

    @POST
    public Response saveLocation();
}
