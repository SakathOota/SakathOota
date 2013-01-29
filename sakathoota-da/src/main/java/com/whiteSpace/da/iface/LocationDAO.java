/**
 * 
 */
package com.whiteSpace.da.iface;

import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.domain.common.types.Locations;

/**
 * @author Shivakumar N
 *
 * @since Jan 28, 2013 5:47:41 PM
 */
public interface LocationDAO {
	public Location createLocation(Location location);
	public Locations getLocationsByPartialName(String partialName);
	public Location getLocationByFBLocationId(Long fbLocationId);
}
