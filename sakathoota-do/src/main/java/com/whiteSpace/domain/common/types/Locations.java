/**
 * 
 */
package com.whiteSpace.domain.common.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Shivakumar N
 *
 * @since Jan 29, 2013 8:43:02 AM
 */
@XmlRootElement(name = "Locations")
@XmlType(name = "Locations")
public class Locations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="location")
	private List<Location> locations;
	
	public List<Location> getLocations() {
		if(locations == null){
			locations = new ArrayList<Location>();
		}
		return locations;
	}
	
}
