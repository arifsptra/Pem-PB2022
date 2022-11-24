package com.example.a03basicappdatabase;

import retrofit2.Retrofit;

public class KoneksiMatakuliah {
    public final static String URL_BASE="http://localhost";
    private static Retrofit retrofit;

    public static Retrofit Koneksi(){
        if(retrofit==NULL){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory()
                    .build();
        }
        return retrofit;
    }
}
