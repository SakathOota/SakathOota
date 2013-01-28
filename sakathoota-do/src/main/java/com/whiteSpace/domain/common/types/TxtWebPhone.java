/**
 * 
 */
package com.whiteSpace.domain.common.types;

/**
 * @author Shivakumar N
 *
 * @since Jan 23, 2013 2:13:15 PM
 */
public class TxtWebPhone {

	public String getEncodedNumber() {
		return encodedNumber;
	}
	public void setEncodedNumber(String encodedNumber) {
		this.encodedNumber = encodedNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	String encodedNumber;
	String phoneNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	Integer id;
	Boolean active;
}
