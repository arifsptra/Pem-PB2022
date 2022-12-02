package com.example.projekunggulan.API;

import com.example.projekunggulan.Model.MakuliahModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IterfacesMatakuliah {
    @GET("akademik/")
    Call<List<MakuliahModel>> tampilmatakuliah();

    @POST("akademik/")
    Call<MakuliahModel> simpanData(@Field("nip") String nip,
                                   @Field("nama_pegawai") String nama_pegawai,
                                   @Field("jenis_kel") String jenis_kel,
                                   @Field("status") String status,
                                   @Field("pendidikan") String pendidikan,
                                   @Field("alamat") String alamat,
                                   @Field("kota") String kota);

    @DELETE("akademik/")
    Call<MakuliahModel> hapusData(@Query("nip") String nip);
}
