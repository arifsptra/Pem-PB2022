package com.example.apppenjualanmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityBeli extends AppCompatActivity {
    TextView nama_pelanggan, nama_mobil, kode_mobil, harga_mobil, totalBeli_mobil, totalHarga_mobil;
    String namaPelanggan, namaMobil, kodeMobil, hargaMobil, totalBeliMobil, totalHargaMobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_beli);

        nama_pelanggan = findViewById(R.id.namaPelangganTextView);
        nama_mobil = findViewById(R.id.merkMobilTextView);
        kode_mobil = findViewById(R.id.kodeMobilTextView);
        harga_mobil = findViewById(R.id.hargaSatuanMobilTextView);
        totalBeli_mobil = findViewById(R.id.jumlahMobilTextView);
        totalHarga_mobil = findViewById(R.id.totalBiayaMobilTextView);

        Bundle bundle = getIntent().getExtras();

        namaPelanggan = bundle.getString("nama_pelanggan");
        namaMobil = bundle.getString("nama_mobil");
        kodeMobil = bundle.getString("kode_mobil");
        hargaMobil = bundle.getString("harga_awal");
        totalBeliMobil = bundle.getString("jumlah_pesan");
        totalHargaMobil = bundle.getString("total_harga");

        nama_pelanggan.setText(namaPelanggan);
        nama_mobil.setText(namaMobil);
        kode_mobil.setText(kodeMobil);
        harga_mobil.setText("Rp. "+hargaMobil);
        totalBeli_mobil.setText(totalBeliMobil+" Unit");
        totalHarga_mobil.setText("Rp. "+totalHargaMobil);
    }
}