package com.whiteSpace.domain.common.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/16/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "Location")
@XmlType(name = "Location")
public class Location implements Serializable {
    String longitude;
    String latitude;
    String subject_id;
    String name;
    String category;
    //Addrrss
    String phone;

}
