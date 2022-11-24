package com.example.projekunggulan.CLASS;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KoneksiMatakuliah {
    public final static String URL_BASE="http://192.168.10.253/~sinaga/";
    private static Retrofit retrofit;

    public static Retrofit Koneksi()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
