package com.inducesmile.androidloginwithretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Start4me on 3/28/2017.
 */

public class Properites1 {

    @SerializedName("email")
    private String email;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;
    @SerializedName("type")
    private String type;

    public Properites1(String email,String firstname,String lastname,String type) {
        this.email = email;
        this.firstname=firstname;
        this.lastname=lastname;
        this.type=type;

    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public  String getFirstname() {
        return firstname;
    }

    public void setFirstname(String fname) {
        this.firstname = fname;
    }
    public  String getLastname() {
        return lastname;
    }

    public void setLastname(String lname) {
        this.lastname = lname;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
