package com.whiteSpace.da.impl;

import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.da.rowMapper.UserRowMapper;
import com.whiteSpace.domain.common.types.User;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: sn1 Date: 1/17/13 Time: 7:55 PM To change
 * this template use File | Settings | File Templates.
 */
public class UserDataDAOImpl extends BaseDAOImpl implements UserDataDAO {
	@Override
	public User createUser(final User user) {
		final String sql = "insert into users (email, fb_id, name, password, dob, gender, food_pref, fb_access_token, fb_acc_tok_expires_on) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql,
						new String[]{"user_id"});
				int i = 1;
				preparedStatement.setString(i++, user.getEmail());
				preparedStatement.setLong(i++, user.getFacebookId());
				preparedStatement.setString(i++, user.getName());
				preparedStatement.setString(i++, user.getPassword());
				preparedStatement.setDate(i++, new Date(user.getDateOfBirth()
						.getTime()));
				preparedStatement.setInt(i++, user.getGender().getValue());
				preparedStatement.setInt(i++, user.getFoodPref().getValue());
				preparedStatement.setString(i++, user.getFbAccessToken());
				preparedStatement.setLong(i++, user.getFbAccessTokenExpires_On());
				return preparedStatement; // To change body of implemented
											// methods use File | Settings |
											// File Templates.
			}
		};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		user.setId(keyHolder.getKey().intValue());
		return user;
	}

	@Override
	public void getUserByEmail(String email) {

	}

	@Override
	public void getUserById(String id) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByFBId(Long fbId) {
		String sql = "select user_id, email, fb_id, name, password, dob, gender, food_pref from users where fb_id = ?";
		List<User> users = jdbcTemplate.query(sql, new Object[]{fbId}, new UserRowMapper());
		if(users.size() > 0){
			return users.get(0);
		} else {
			//FIXME: throw record not found exceptions
			return null;
		}
	}
}
