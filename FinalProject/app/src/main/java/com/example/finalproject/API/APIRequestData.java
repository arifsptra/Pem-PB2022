package com.example.finalproject.API;

import com.example.finalproject.Model.ResponseModelBarang;
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

    @FormUrlEncoded
    @POST("tambahBarang.php")
    Call<ResponseModelBarang> ardCreateData(
            @Field("kode") String kode,
            @Field("nama") String nama,
            @Field("satuan") String satuan,
            @Field("harga") String harga,
            @Field("stok") String stok,
            @Field("gambar") String gambar
    );
}
