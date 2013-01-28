package com.whiteSpace.resource.impl;

import com.whiteSpace.da.iface.LocationDAO;
import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.resource.iface.LocationResource;
import com.whiteSpace.ws.commons.ResponseHandler;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/15/13
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class LocationResourceImpl implements LocationResource {
    
	@Autowired
	private LocationDAO locationDAO;
	
	@Override
    public Response getLocation(String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response createLocation(Location location) {
        //FIXME: Add validation code 
    	location = locationDAO.createLocation(location);
    	return ResponseHandler.getOKResponse(location);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
