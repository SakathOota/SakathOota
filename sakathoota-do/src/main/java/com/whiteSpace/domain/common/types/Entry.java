package com.whiteSpace.domain.common.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/20/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlType(name = "entry", propOrder = {"uid", "id", "time", "changed_fields"})
public class Entry {
    Long uid;
    Long id;
    Long time;
    List<String> changed_fields;
}
