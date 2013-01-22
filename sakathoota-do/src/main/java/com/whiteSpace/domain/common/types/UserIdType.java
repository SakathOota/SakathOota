/**
 * 
 */
package com.whiteSpace.domain.common.types;

/**
 * @author Shivakumar N
 *
 * @since Jan 22, 2013 8:47:15 PM
 */
public enum UserIdType {
	EMAIL_ID,
	FACEBOOK_ID,
	USER_ID,
	FOUR_SQ_ID;

	public String value(){
		return name();
	}
	
	public static UserIdType fromValue(String v){
		return valueOf(v);
	}
	
	public static boolean contains(String v) {
        for (UserIdType type : UserIdType.values()) {
            if (type.name().equals(v)) {
                return true;
            }
        }
        return false;
    }
}
