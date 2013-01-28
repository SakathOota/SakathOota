/**
 * 
 */
package com.whiteSpace.resource.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.whiteSpace.da.iface.TxtWebDAO;
import com.whiteSpace.domain.common.types.TxtWebPhone;
import com.whiteSpace.resource.iface.TxtWebResource;

/**
 * @author Shivakumar N
 *
 * @since Jan 23, 2013 2:13:29 PM
 */
public class TxtWebResourceImpl implements TxtWebResource {

	@Autowired
	private TxtWebDAO txtWebDAO;
	
	@Override
	public Response register(String txtWebMobile, String txtWebMsg) {
		String msg = null;
		if (txtWebMsg == null) {
			msg = "Please enter Mobile number <br /> Format:<br />@gfood.u 9988776655";
			return Response.ok(msg).build();
		} else {
			TxtWebPhone txtWebPhone = new TxtWebPhone();
			txtWebPhone.setEncodedNumber(txtWebMobile);
			txtWebPhone.setPhoneNumber(txtWebMsg);
			txtWebPhone.setActive(true);
			txtWebDAO.setTxtWebPhone(txtWebPhone);
		}
		return Response.ok("Added Successfully").build();
	}
}
