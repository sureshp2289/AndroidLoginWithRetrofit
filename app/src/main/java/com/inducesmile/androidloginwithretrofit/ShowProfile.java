package com.inducesmile.androidloginwithretrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Start4me on 3/28/2017.
 */

public class ShowProfile implements Serializable {
    @SerializedName("tag")
    private String tag;
    @SerializedName("error")
    private boolean error;
    @SerializedName("error_msg")
    private String error_msg;
    @SerializedName("getuserdetails")
    UserDetails user;
    @SerializedName("getservices")
    ArrayList<Service> services;

    public ShowProfile(String tag, boolean error,String error_msg){
        this.tag = tag;
        this.error = error;
        this.error_msg = error_msg;

    }
    public String getTag() {
        return tag ;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getError_msg() {
        return error_msg ;
    }

    public void setError_msg(String emsg) {
        this.error_msg = emsg;
    }
    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }


    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
    public ArrayList<Service> getServices(){
        return services;
    }

    public void setUsers(ArrayList<Service> services) {
        this.services= services;
    }
}
