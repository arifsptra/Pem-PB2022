package com.example.applaundry.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.applaundry.API.APIRequestData;
import com.example.applaundry.API.RetroServer;
import com.example.applaundry.Adapter.AdapterData;
import com.example.applaundry.Model.DataModel;
import com.example.applaundry.Model.ResponseModel;
import com.example.applaundry.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listData;
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;
    private FloatingActionButton fab_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srlData = findViewById(R.id.swl_data);
        pbData = findViewById(R.id.pb_data);
        rvData = findViewById(R.id.rv_data);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        fab_tambah = findViewById(R.id.fab_tambah);

        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                retrieveData();
                srlData.setRefreshing(false);
            }
        });

        fab_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                // Toast.makeText(MainActivity.this, "Kode: "+kode+" | pesan: "+pesan, Toast.LENGTH_SHORT).show();
                listData = response.body().getData();
                adData = new AdapterData(MainActivity.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server: "+t.getMessage(), Toast.LENGTH_SHORT).show();

                pbData.setVisibility(View.INVISIBLE);
            }
        });
    }
}