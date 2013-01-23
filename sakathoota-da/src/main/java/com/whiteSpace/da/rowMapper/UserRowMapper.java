/**
 * 
 */
package com.whiteSpace.da.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.whiteSpace.domain.common.types.FoodPreference;
import com.whiteSpace.domain.common.types.Gender;
import com.whiteSpace.domain.common.types.User;

/**
 * @author Shivakumar N
 *
 * @since Jan 22, 2013 9:21:44 PM
 */
public class UserRowMapper implements RowMapper {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		//FIXME: Add all fields, user_id, email, fb_id, name, password, dob, gender, food_pref
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setEmail(rs.getString("email"));
		user.setFacebookId(rs.getLong("fb_id"));
		user.setDateOfBirth(rs.getDate("dob"));
		user.setName(rs.getString("name"));
		user.setGender(Gender.forCode(rs.getInt("gender")));
		user.setFoodPref(FoodPreference.forCode(rs.getInt("food_pref")));
		user.setFbAccessToken(rs.getString("fb_access_token"));
		user.setFbAccessTokenExpires_On(rs.getLong("fb_acc_tok_expires_on"));
		return user;
	}

}
