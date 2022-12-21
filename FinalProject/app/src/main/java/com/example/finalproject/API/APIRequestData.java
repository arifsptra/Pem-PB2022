package com.example.finalproject.API;

import com.example.finalproject.Model.ResponseModelLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
//    @GET("retrofit.php")
//    Call<ResponseModelLogin> ardRetrieveData();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseModelLogin> ardLoginData(
            @Field("username") String username,
            @Field("password") String password
    );
}
