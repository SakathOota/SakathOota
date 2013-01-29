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
			
			return Response.ok(buildResponse(msg)).header("txtweb-appkey", "5f2b5eaf-389d-4025-bc2c-adc1ee0129ae").build();
		} else {
			TxtWebPhone txtWebPhone = new TxtWebPhone();
			txtWebPhone.setEncodedNumber(txtWebMobile);
			txtWebPhone.setPhoneNumber(txtWebMsg);
			txtWebPhone.setActive(true);
			txtWebDAO.setTxtWebPhone(txtWebPhone);
		}
		return Response.ok(buildResponse("Added Successfully")).header("txtweb-appkey", "5f2b5eaf-389d-4025-bc2c-adc1ee0129ae").build();
	}
	
	private String buildResponse(String msg){
		return "<html><head><meta name=\"txtweb-appkey\" content=\"5f2b5eaf-389d-4025-bc2c-adc1ee0129ae\" /></head><body>"
		+msg 
		+"</body></html>";
	}
}

