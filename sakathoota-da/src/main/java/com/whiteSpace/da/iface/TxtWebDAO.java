/**
 * 
 */
package com.whiteSpace.da.iface;

import java.util.List;

import com.whiteSpace.domain.common.types.TxtWebPhone;

/**
 * @author Shivakumar N
 *
 * @since Jan 23, 2013 9:47:23 AM
 */
public interface TxtWebDAO {

	public TxtWebPhone readTxtWebPhone(TxtWebPhone txtWebPhone);
	public TxtWebPhone updateTxtWebPhone(TxtWebPhone txtWebPhone) ;
	public TxtWebPhone createTxtWebPhone(TxtWebPhone txtWebPhone);
	public List<TxtWebPhone> getActivePhones();
	public TxtWebPhone setTxtWebPhone(TxtWebPhone txtWebPhone);
	
}
