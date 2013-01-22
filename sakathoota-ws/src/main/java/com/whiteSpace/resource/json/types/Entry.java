package com.whiteSpace.resource.json.types;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/20/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Entry {
    private Long id;
    private Long uid;
    private Long time;
    private List<String> changed_fields;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public List<String> getChanged_fields() {
        return changed_fields;
    }

    public void setChanged_fields(List<String> changed_fields) {
        this.changed_fields = changed_fields;
    }
}
