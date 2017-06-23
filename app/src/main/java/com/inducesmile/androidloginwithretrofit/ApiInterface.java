package com.inducesmile.androidloginwithretrofit;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    @Headers({"Accept:application/json"})
    @POST("/users/sign_in")
    Call<UserLogin> login(
            @Header("Content-Type") String  str,
            @Body JsonObject method);
    @Headers({"Accept:application/json"})
    @GET("/get_feeds")
    Call<JsonObject> getfeeds(
            @Header("X-ACCESS-TOKEN") String  accestoken,
            @Header("X-USER-EMAIL") String  email
            );
}
