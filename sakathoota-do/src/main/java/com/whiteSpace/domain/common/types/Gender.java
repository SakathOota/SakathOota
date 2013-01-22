package com.whiteSpace.domain.common.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/20/13
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlType(name="Gender")
@XmlEnum
public enum Gender {

    NOT_SPECIFIED(0),
    MALE(1),
    FEMALE(2);

    private int value;

    private Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
