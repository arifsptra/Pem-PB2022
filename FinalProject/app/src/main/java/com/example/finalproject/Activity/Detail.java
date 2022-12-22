package com.example.finalproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finalproject.R;

public class Detail extends AppCompatActivity {

    private String xKode, xNama, xSatuan, xHarga, xStok, xGambar;
    private TextView tvKode, tvNama, tvSatuan, tvHarga, tvStok, tvGambar;
    private Button bUbah;
    private String yKode, yNama, ySatuan, yHarga, yStok, yGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent terima = getIntent();
        xKode = terima.getStringExtra("xKode");
        xNama = terima.getStringExtra("xNama");
        xSatuan = terima.getStringExtra("xSatuan");
        xHarga = terima.getStringExtra("xHarga");
        xStok = terima.getStringExtra("xStok");
//        xGambar = terima.getStringExtra("xGambar");

//        etKode = findViewById(R.id.et_kode);
        tvNama = findViewById(R.id.tv_nama);
        tvSatuan = findViewById(R.id.tv_satuan);
        tvHarga = findViewById(R.id.tv_harga);
//        tvStok = findViewById(R.id.tv_stok);
//        etGambar = findViewById(R.id.et_gambar);

//        etKode.setText(xKode);
        tvNama.setText(xNama);
        tvSatuan.setText(xSatuan);
        tvHarga.setText(xHarga);
//        tvStok.setText(xStok);
//        etGambar.setText(xGambar);

    }
}