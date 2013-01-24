package com.whiteSpace.resource.iface;

import fi.foyt.foursquare.api.FoursquareApiException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.MalformedURLException;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 1/23/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/fsauth")
public interface FSCredentialsController {
    @GET
    @Path("/login")
    public Response loginRedirectToFS(@Context UriInfo uriInfo);

    @GET
    @Path("/redirect")
    public Response redirectCallback(String authorizationCode, UriInfo uriInfo) throws FoursquareApiException, MalformedURLException;

}
