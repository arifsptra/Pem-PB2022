package com.example.finalproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.API.APIRequestData;
import com.example.finalproject.API.RetrofitServer;
import com.example.finalproject.Model.ResponseModelBarang;
import com.example.finalproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Master extends AppCompatActivity {

    EditText etKode, etNama, etSatuan, etHarga, etStok, etGambar;
    String kode, nama, satuan, harga, stok, gambar;
    Button bSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        etKode = findViewById(R.id.et_kode);
        etNama = findViewById(R.id.et_nama);
        etSatuan = findViewById(R.id.et_satuan);
        etHarga = findViewById(R.id.et_harga);
        etStok = findViewById(R.id.et_stok);
        etGambar = findViewById(R.id.et_gambar);
        bSimpan = findViewById(R.id.b_simpan);

        bSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kode = etKode.getText().toString();
                nama = etNama.getText().toString();
                satuan = etSatuan.getText().toString();
                harga = etHarga.getText().toString();
                stok = etStok.getText().toString();
                gambar = etGambar.getText().toString();

                if(kode.trim().equals("")){
                    etKode.setError("Kode Harus Diisi");
                }else if(nama.trim().equals("")){
                    etNama.setError("Nama Harus Diisi");
                }else if(satuan.trim().equals("")){
                    etSatuan.setError("Telepon Harus Diisi");
                }else if(harga.trim().equals("")){
                    etHarga.setError("Harga Harus Diisi");
                }else if(stok.trim().equals("")){
                    etStok.setError("Stok Harus Diisi");
                }else{
                    createData();
                }
            }
        });
    }

    private void createData(){
        APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModelBarang> simpanData = ardData.ardCreateData(kode, nama, satuan, harga, stok, gambar);

        simpanData.enqueue(new Callback<ResponseModelBarang>() {
            @Override
            public void onResponse(Call<ResponseModelBarang> call, Response<ResponseModelBarang> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(Master.this, pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModelBarang> call, Throwable t) {
                Toast.makeText(Master.this, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}