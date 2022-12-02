package com.example.projekunggulan.CLASS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projekunggulan.API.IterfacesMatakuliah;
import com.example.projekunggulan.Adapter.AdaptorMtkul;
import com.example.projekunggulan.Model.MakuliahModel;
import com.example.projekunggulan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAPIMatakuliah extends AppCompatActivity {
    RecyclerView recyclerViewmtkul;
    IterfacesMatakuliah iterfacesMatakuliah;
    KoneksiMatakuliah koneksiMatakuliah;
    FloatingActionButton tombolInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_apimatakuliah);
        recyclerViewmtkul=findViewById(R.id.recyclerviewmtkl);

        iterfacesMatakuliah=KoneksiMatakuliah.Koneksi().create(IterfacesMatakuliah.class);
        recyclerViewmtkul.setLayoutManager(new LinearLayoutManager(this));

        tombolInput = findViewById(R.id.tombolInput);
        tombolInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestAPIMatakuliah.this, EntryDataMatakuliah.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tampil_matakuliah();
    }

    private void tampil_matakuliah() {
        Call<List<MakuliahModel>> view_mtkul=iterfacesMatakuliah.tampilmatakuliah();
        view_mtkul.enqueue(new Callback<List<MakuliahModel>>() {
            @Override
            public void onResponse(Call<List<MakuliahModel>> call, Response<List<MakuliahModel>> response) {
                ArrayList<MakuliahModel> makuliahModelArrayList= (ArrayList<MakuliahModel>) response.body();
                AdaptorMtkul adaptorMtkul=new AdaptorMtkul(makuliahModelArrayList);
                recyclerViewmtkul.setAdapter(adaptorMtkul);
                //Toast.makeText(RestAPIMatakuliah.this, "Berhasil ..."+makuliahModelArrayList.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<MakuliahModel>> call, Throwable t) {
                Toast.makeText(RestAPIMatakuliah.this, "Gagal....", Toast.LENGTH_SHORT).show();
            }
        });

    }
}