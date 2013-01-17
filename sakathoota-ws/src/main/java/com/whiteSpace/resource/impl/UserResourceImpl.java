package com.whiteSpace.resource.impl;

import com.whiteSpace.resource.iface.UserResource;
import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/15/13
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserDataDAO userDataDAO;

    @Override
    public Response getUser(String id) {

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response createUser(User user) {
        //FIXME: write validation code
        userDataDAO.createUser(user);
        return null;
    }
}
