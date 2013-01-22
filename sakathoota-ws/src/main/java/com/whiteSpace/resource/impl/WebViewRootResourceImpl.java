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
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;
import com.whiteSpace.resource.iface.WebViewRootResource;

/**
 * @author Shivakumar N
 *
 * @since Jan 21, 2013 11:24:10 PM
 */
public class WebViewRootResourceImpl implements WebViewRootResource{
		
	@Override
	 	@GET
	    @Produces("text/html")
	    public Response index() {
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("user", "usul");
	        List<String> l = new ArrayList<String>();
	        l.add("light saber");
	        l.add("fremen clothes");
	        map.put("items", l);
	        return Response.ok(new Viewable("/index.jsp", map)).build();
	    }

}
