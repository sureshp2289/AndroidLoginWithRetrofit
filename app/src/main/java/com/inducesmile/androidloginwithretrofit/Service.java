package com.inducesmile.androidloginwithretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Start4me on 3/28/2017.
 */

public class Service {

    @SerializedName("serviceid")
    private String serviceid;

    @SerializedName("servicename")
    private String servicename;

    @SerializedName("serviceprice")
    private String serviceprice;

    @SerializedName("servicedesc")
    private String servicedesc;

    @SerializedName("serviceimage")
    private String serviceimage;

 public Service(String serviceid,String servicename,String serviceprice,String servicedesc,String serviceimage)
    {
       this.serviceid=serviceid;
        this.servicename=servicename;
        this.serviceprice=serviceprice;
        this.servicedesc=servicedesc;
        this.serviceimage=serviceimage;
    }
    public  String getServiceid()
    {
        return serviceid;
    }
    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }
    public  String getServicename()
    {
        return servicename;
    }
    public void setServicename(String servicename) {
        this.servicename = servicename;
    }
    public  String getServiceprice()
    {
        return serviceprice;
    }
    public void setServiceprice(String serviceprice) {
        this.serviceprice = serviceprice;
    }
    public  String getServicedesc()
    {
        return servicedesc;
    }
    public void setServicedesc(String servicedesc) {
        this.servicedesc = servicedesc;
    }
    public  String getServiceimage()
    {
        return serviceimage;
    }
    public void setServiceimage(String serviceimage) {
        this.serviceimage = serviceimage;
    }
}
