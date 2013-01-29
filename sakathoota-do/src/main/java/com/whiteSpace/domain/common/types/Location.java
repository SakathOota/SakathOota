package com.whiteSpace.domain.common.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA. User: sn1 Date: 1/16/13 Time: 11:03 PM To change
 * this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "Location")
@XmlType(name = "Location")
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double longitude;
	private Double latitude;
	private Integer id;
	private String name;
	private String category;
	// Address
	private String phone;
	private String landMark;
	private String street;
	private String city;
	private Long fbLocationId;

	public Long getFbLocationId() {
		return fbLocationId;
	}
	public void setFbLocationId(Long fbLocationId) {
		this.fbLocationId = fbLocationId;
	}
	private User user;
	
	@Deprecated
	public User getUser() {
		return user;
	}
	@Deprecated
	public void setUser(User user) {
		this.user = user;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
