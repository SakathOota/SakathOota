/**
 * 
 */
package com.whiteSpace.resource.impl;

import javax.ws.rs.core.Response;

import com.whiteSpace.da.iface.TxtWebDAO;
import com.whiteSpace.domain.common.types.TxtWebPhone;
import com.whiteSpace.resource.iface.TxtWebResource;

/**
 * @author Shivakumar N
 *
 * @since Jan 23, 2013 2:13:29 PM
 */
public class TxtWebResourceImpl implements TxtWebResource {

	private TxtWebDAO txtWebDAO;
	@Override
	public Response register(String txtWebMobile, String txtWebMsg) {
		String msg = null;
		if (txtWebMsg == null) {
			msg = "Please enter Mobile number <br /> Format:<br />@gfood.u 9988776655";
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
