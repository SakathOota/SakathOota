package com.whiteSpace.da.iface;

import com.whiteSpace.domain.common.types.User;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/17/13
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDataDAO {
    public User createUser(User user);
    public User getUserByEmail(String email);
    public User getUserById(String id);
    public User getUserByFBId(Long fbId);
    
    //update accessToken and expiryDay by fbId
    public void updateAccessTokenByFBId(Long fbId, String accessToken, Long expiryTime);
    
}
