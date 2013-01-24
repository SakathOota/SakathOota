package com.whiteSpace.resource.impl;

import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.domain.common.types.UserIdType;
import com.whiteSpace.resource.iface.FSCredentialsController;
import com.whiteSpace.ws.commons.FS2NativeMapper;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompleteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.MalformedURLException;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 1/23/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/fsauth")
public class FSCredentialsControllerImpl implements FSCredentialsController{

    @Autowired
    private UserDataDAO userDataDAO;

    @Value("${foursquare.clientId}")
    String client_id;

    @Value("${foursquare.clientSecret}")
    String client_secret;

    @Value("${fs.auth.redirect.url}")
    String redirect_uri;

    @GET
    @Path("/login")
    @Override
    public Response loginRedirectToFS(@Context UriInfo uriInfo){
        FoursquareApi foursquareApi = new FoursquareApi(client_id,client_secret,redirect_uri);
        return Response.seeOther(URI.create(foursquareApi.getAuthenticationUrl())).build();  //To change body of implemented methods use File | Settings | File Templates.
   }

    @GET
    @Path("/redirect")
    @Override
    public Response redirectCallback(String authorizationCode, UriInfo uriInfo) throws FoursquareApiException, MalformedURLException {
        String fsAccessToken = null;
        FoursquareApi foursquareApi = null;
        Long fsId = null;
        try{
            if (!authorizationCode.equals("")) {
                foursquareApi = new FoursquareApi(client_id, client_secret, redirect_uri);
                foursquareApi.authenticateCode(authorizationCode);
            }
            System.out.println(foursquareApi.getOAuthToken());
            fsAccessToken = foursquareApi.getOAuthToken();
            Result<CompleteUser> user = foursquareApi.user(null);
            CompleteUser fsUserProfile = user.getResult();
            if (user.getMeta().getCode() == 200) {
                fsId = Long.parseLong(fsUserProfile.getId());
                System.out.println("&&&&&&&&&&&&&&&&&&&" + user.getResult().getId());
            }
            if(userDataDAO.getUserByFBId(fsId) != null){
                userDataDAO.updateAccessTokenByFSId(fsId,fsAccessToken);
            }
            else {
                User newUser = FS2NativeMapper.mapUser(fsUserProfile,fsAccessToken);
                userDataDAO.createUser(newUser);
            }
            URI url = URI.create(uriInfo.getBaseUri().toURL().toString() + "web/user/" + fsId +"?idType="+ UserIdType.FOUR_SQ_ID);
            return Response.seeOther(url).build();
        }
        catch (FoursquareApiException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    } //To change body of implemented methods use File | Settings | File Templates.
}

