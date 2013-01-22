package com.whiteSpace.resource.json.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/20/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Notification {
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Entry> getEntry() {
        if(entry == null){
            entry = new ArrayList<Entry>();
        }
        return entry;
    }

    private String object;
    private List<Entry> entry;
}
