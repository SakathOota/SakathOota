package com.whiteSpace.da.impl;

import com.whiteSpace.da.iface.BaseDAO;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/17/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseDAOImpl implements BaseDAO {

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected JdbcTemplate jdbcTemplate;

}
