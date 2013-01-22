package com.whiteSpace.domain.common.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/16/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "User")
@XmlType(name = "User", propOrder = {"id", "email", "facebookId", "name", "password", "dateOfBirth", "gender", "foodPref"})
public class User implements Serializable {

    private Integer id;
    private String email;
    private Long facebookId;
    private String name;
    private String password;
    private Date dateOfBirth;
    private Gender gender;
    private FoodPreference foodPref;

    public FoodPreference getFoodPref() {
        return foodPref;
    }

    public void setFoodPref(FoodPreference foodPref) {
        this.foodPref = foodPref;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(Long facebookId) {
        this.facebookId = facebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
