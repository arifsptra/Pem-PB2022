package com.example.applaundry.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseURL = "http://192.168.34.120/laundry/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if(retro==null){
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
