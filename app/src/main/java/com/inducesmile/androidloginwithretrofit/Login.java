package com.inducesmile.androidloginwithretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Login implements Serializable {
    @SerializedName("tag")
    private String tag;
    @SerializedName("error")
    private boolean error;
    @SerializedName("error_msg")
    private String error_msg;
    @SerializedName("uid")
    private String uid;

    @SerializedName("user")
    Properties properties;
    @SerializedName("type")
    private String type;

    public Login(String tag, boolean error,String error_msg,String uid,String type){
        this.tag = tag;
        this.error = error;
        this.error_msg = error_msg;
        this.uid = uid;
        this.type = type;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}

