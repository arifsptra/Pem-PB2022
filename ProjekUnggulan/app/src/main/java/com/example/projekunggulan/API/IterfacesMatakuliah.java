package com.example.projekunggulan.API;

import com.example.projekunggulan.Model.MakuliahModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IterfacesMatakuliah {
    @GET("siswa/")
    Call<List<MakuliahModel>> tampilmatakuliah();
}
