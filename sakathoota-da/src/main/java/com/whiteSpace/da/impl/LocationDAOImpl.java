/**
 * 
 */
package com.whiteSpace.da.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.whiteSpace.da.iface.LocationDAO;
import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.domain.common.types.Locations;

/**
 * @author Shivakumar N
 *
 * @since Jan 28, 2013 5:48:01 PM
 */
public class LocationDAOImpl extends BaseDAOImpl implements LocationDAO{

	@Override
	public Location createLocation(final Location location) {
		final String query = "insert into locations (name, longitude, latitude, landmark, phone, street, city, fb_loc_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(query, new String[]{"user_id"});
				int i = 1;
				preparedStatement.setString(i++, location.getName());
				preparedStatement.setDouble(i++, location.getLongitude());
				preparedStatement.setDouble(i++, location.getLatitude());
				preparedStatement.setString(i++, location.getLandMark());
				preparedStatement.setString(i++, location.getPhone());
				preparedStatement.setString(i++, location.getStreet());
				preparedStatement.setString(i++, location.getCity());
				preparedStatement.setLong(i++, location.getFbLocationId());
				return preparedStatement;
			}
		};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		location.setId(keyHolder.getKey().intValue());
		return location;
	}

	@Override
	public Locations getLocationsByPartialName(String partialName) {
		final String query = "select * from locations where name like ?";
		List<Location> locationList = jdbcTemplate.query(query, new Object[]{"%" + partialName + "%"}, new BeanPropertyRowMapper(Location.class));
		
		Locations locations = new Locations();
		locations.getLocations().addAll(locationList);
		return locations;
	}

	@Override
	public Location getLocationByFBLocationId(Long fbLocationId) {
		final String query = "select * from locations where fb_loc_id = ?";
		List<Location> locationList = jdbcTemplate.query(query, new Object[]{fbLocationId}, new BeanPropertyRowMapper(Location.class));
		if(locationList.size() > 0){
			return locationList.get(0);
		}
		return null;
	}
}
