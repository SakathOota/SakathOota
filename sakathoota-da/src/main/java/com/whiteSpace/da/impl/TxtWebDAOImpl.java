/**
 * 
 */
package com.whiteSpace.da.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.whiteSpace.da.iface.TxtWebDAO;
import com.whiteSpace.domain.common.types.TxtWebPhone;

/**
 * @author Shivakumar N
 * 
 * @since May 1, 2012 9:25:26 PM
 */
public class TxtWebDAOImpl extends BaseDAOImpl implements TxtWebDAO {

	public TxtWebPhone setTxtWebPhone(TxtWebPhone txtWebPhone) {
		TxtWebPhone phone = readTxtWebPhone(txtWebPhone);
		if(phone == null){
			createTxtWebPhone(txtWebPhone);
		}else if(phone.getActive().equals(txtWebPhone.getActive()) && phone.getPhoneNumber().equals(txtWebPhone.getPhoneNumber())){
			//do nothing
		}else{
			updateTxtWebPhone(txtWebPhone);
		}
		return null;
	}

	public List<TxtWebPhone> getActivePhones(){
		String sql = "select * from txtweb_phones where active = 1";
		@SuppressWarnings("unchecked")
		List<TxtWebPhone> phones = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TxtWebPhone.class));
		return phones;
	}
	public TxtWebPhone createTxtWebPhone(TxtWebPhone txtWebPhone) {
		String sql = "insert into txtweb_phones(phone_number, encoded_number,active) values(?,?,?)";
		jdbcTemplate.update(sql, new Object[]{txtWebPhone.getPhoneNumber(), txtWebPhone.getEncodedNumber(), txtWebPhone.getActive()});
		return txtWebPhone;
	}

	public TxtWebPhone updateTxtWebPhone(TxtWebPhone txtWebPhone) {

		String sql = "update txtweb_phones set phone_number = ?, active = ? where encoded_number = ?";
		jdbcTemplate.update(sql, new Object[]{txtWebPhone.getPhoneNumber(), txtWebPhone.getActive(), txtWebPhone.getEncodedNumber()});
		return txtWebPhone;
	}

	public TxtWebPhone readTxtWebPhone(TxtWebPhone txtWebPhone) {

		String sql = "select * from txtweb_phones where encoded_number = ?";
		try{
		txtWebPhone = (TxtWebPhone) jdbcTemplate.queryForObject(sql, new Object[]{txtWebPhone.getEncodedNumber()}, new BeanPropertyRowMapper(TxtWebPhone.class));
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
		return txtWebPhone;
	}

}
