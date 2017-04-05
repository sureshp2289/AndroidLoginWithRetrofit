package com.inducesmile.androidloginwithretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Start4me on 3/28/2017.
 */

public class UserDetails {
    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("uid")
    private String uid;

    @SerializedName("email")
    private String email;

    @SerializedName("type")
    private String type;

    @SerializedName("number")
    private String number;

    @SerializedName("lat")
    private String lat;

    @SerializedName("long")
    private String long1;

    @SerializedName("address")
    private String address;

    @SerializedName("stripeaccess")
    private String stripeaccess;

    @SerializedName("stripeid")
    private String stripeid;

    @SerializedName("profileimage")
    private String profileimage;
    UserDetails(String firstname,String lastname,String uid,String email,String type,String number,String lat,String long1,String address,String Stripacess,String stripeid,String profileimage)
    {
       this.firstname=firstname;
        this.lastname=lastname;
        this.uid=uid;
        this.email=email;
        this.type=type;
        this.number=number;
        this.lat=lat;
        this.long1=long1;
        this.address=address;
        this.stripeaccess=Stripacess;
        this.stripeid=stripeid;
        this.profileimage=profileimage;

    }

   public  String getFirstname()
   {
       return firstname;
   }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public  String getLastname()
    {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = firstname;
    }
    public  String getUid()
    {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public  String getEmail()
    {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public  String getType()
    {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public  String getNumber()
    {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public  String getLat()
    {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public  String getLong1()
    {
        return long1;
    }
    public void setLong1(String long1) {
        this.long1 = long1;
    }
    public  String getAddress()
    {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public  String getStripeaccess()
    {
        return stripeaccess;
    }
    public void setStripeaccess(String stripeaccess) {
        this.stripeaccess = stripeaccess;
    }
    public  String getStripeid()
    {
        return stripeid;
    }
    public void setStripeid(String stripeid) {
        this.stripeid = stripeid;
    }
    public  String getProfileimage()
    {
        return profileimage;
    }
    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }
}
