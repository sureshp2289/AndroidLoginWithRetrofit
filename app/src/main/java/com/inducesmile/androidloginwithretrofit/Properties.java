package com.inducesmile.androidloginwithretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Start4me on 3/28/2017.
 */

public class Properties  {

    @SerializedName("email")
    private String email;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    public Properties(String email,String firstname,String lastname) {
        this.email = email;
        this.firstname=firstname;
        this.lastname=lastname;

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
}