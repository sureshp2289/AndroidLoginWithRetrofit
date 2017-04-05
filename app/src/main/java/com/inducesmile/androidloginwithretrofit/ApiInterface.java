package com.inducesmile.androidloginwithretrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/ondemandapp/index.php")
    Call<Login> post(
            @Field("tag") String method,
            @Field("email") String email,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("/ondemandapp/index.php")
    Call<Register> register(
            @Field("tag") String method,
            @Field("email") String email,
            @Field("password") String password,
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("type") String type
    );
    @Multipart
    @POST("/ondemandapp/index.php")
    Call<Update> update(
            @Part("tag") RequestBody method,
            @Part("uid") RequestBody  uid,
            @Part("firstname") RequestBody firstname,
            @Part("lastname") RequestBody lastname,
            @Part("number") RequestBody number,
            @Part("lat") RequestBody lat,
            @Part("long") RequestBody lon,
            @Part("address") RequestBody address,
            @Part("profileimage") RequestBody image
    );
    @FormUrlEncoded
    @POST("/ondemandapp/index.php")
    Call<ShowProfile> showprofile(
            @Field("tag") String method,
            @Field("uid") String uid

    );
}
