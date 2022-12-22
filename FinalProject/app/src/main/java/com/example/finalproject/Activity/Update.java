package com.example.finalproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.window.SplashScreen;

import com.example.finalproject.API.APIRequestData;
import com.example.finalproject.API.RetrofitServer;
import com.example.finalproject.Model.ResponseModelBarang;
import com.example.finalproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Update extends AppCompatActivity {

    private String xKode, xNama, xSatuan, xHarga, xStok, xGambar;
    private EditText etKode, etNama, etSatuan, etHarga, etStok, etGambar;
    private Button bUbah;
    private String yKode, yNama, ySatuan, yHarga, yStok, yGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent terima = getIntent();
        xKode = terima.getStringExtra("xKode");
        xNama = terima.getStringExtra("xNama");
        xSatuan = terima.getStringExtra("xSatuan");
        xHarga = terima.getStringExtra("xHarga");
        xStok = terima.getStringExtra("xStok");
//        xGambar = terima.getStringExtra("xGambar");

//        etKode = findViewById(R.id.et_kode);
        etNama = findViewById(R.id.et_nama);
        etSatuan = findViewById(R.id.et_satuan);
        etHarga = findViewById(R.id.et_harga);
        etStok = findViewById(R.id.et_stok);
//        etGambar = findViewById(R.id.et_gambar);
        bUbah = findViewById(R.id.b_ubah);

//        etKode.setText(xKode);
        etNama.setText(xNama);
        etSatuan.setText(xSatuan);
        etHarga.setText(xHarga);
        etStok.setText(xStok);
//        etGambar.setText(xGambar);

        bUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                yKode = etKode.getText().toString();
                yNama = etNama.getText().toString();
                ySatuan = etSatuan.getText().toString();
                yHarga = etHarga.getText().toString();
                yStok = etStok.getText().toString();
//                yGambar = etGambar.getText().toString();

                updateData();
            }
        });
    }
    private void updateData(){
        APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModelBarang> ubahData = ardData.ardUpdateData(xKode, yNama, ySatuan, yHarga, yStok);

        ubahData.enqueue(new Callback<ResponseModelBarang>() {
            @Override
            public void onResponse(Call<ResponseModelBarang> call, Response<ResponseModelBarang> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(Update.this, "Kode: "+kode+" | Pesan: "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModelBarang> call, Throwable t) {
                Toast.makeText(Update.this, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}