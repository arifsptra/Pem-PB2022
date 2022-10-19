package com.example.appmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityBeli extends AppCompatActivity {
    TextView nama_menu, total_text, jumlah_pesan, harga_awal;

    String namaMenu, totalText, jumlahPesan, hargaAwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_beli);

        nama_menu=findViewById(R.id.nama_menu);
        total_text=findViewById(R.id.harga_menu);
        jumlah_pesan=findViewById(R.id.jumlah_pesan);
        harga_awal=findViewById(R.id.harga_awal);

        Bundle bundle=getIntent().getExtras();

        namaMenu=bundle.getString("nama_menu");
        totalText=bundle.getString("total_harga");
        jumlahPesan=bundle.getString("jumlah_pesan");
        hargaAwal=bundle.getString("harga_awal");

        nama_menu.setText(namaMenu);
        total_text.setText("Rp. "+totalText);
        jumlah_pesan.setText(jumlahPesan+" Porsi");
        harga_awal.setText("Rp. "+hargaAwal);
    }
}