/**
 * 
 */
package com.whiteSpace.resource.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jersey.api.view.Viewable;
import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.resource.iface.WebViewRootResource;

/**
 * @author Shivakumar N
 * 
 * @since Jan 21, 2013 11:24:10 PM
 */
public class WebViewRootResourceImpl implements WebViewRootResource {

	@Autowired
	UserDataDAO userDataDAO;

	private FBDataAccess dataAccess;

	public void setDataAccess(FBDataAccess dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public Response index() {
		return Response.ok(new Viewable("/index.jsp")).build();
	}

	@Override
	public Response showUser(String id, String idType, Request request) {
		// AAAGNxAItAjIBALzZBT9bIFJIaJLP0sy7ZCDCzIbHHyNiK5ESx4ThZCbepTko85KyAss9xuLulfxszIYZCmTjJyAHLTk2sPV2Yu0hVCnp7gZDZD
		User user = userDataDAO.getUserByFBId(Long.parseLong(id));
		if(user != null){
			dataAccess.getUserLatestCheckin(userDataDAO.getUserByFBId(Long.parseLong(id)).getFbAccessToken());
		}
		
		return Response.ok(new Viewable("/user.jsp")).build();
	}

}
