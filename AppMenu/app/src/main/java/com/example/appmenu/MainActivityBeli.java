package com.example.appmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityBeli extends AppCompatActivity {
    TextView nama_menu, total_text, jumlah_pesan;

    String namaMenu, totalText, jumlahPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_beli);

        nama_menu=findViewById(R.id.nama_menu);
        total_text=findViewById(R.id.harga_menu);
        jumlah_pesan=findViewById(R.id.jumlah_pesan);

        Bundle bundle=getIntent().getExtras();

        namaMenu=bundle.getString("nama_menu");
        totalText=bundle.getString("total_harga");
        jumlahPesan=bundle.getString("jumlah_pesan");

        nama_menu.setText(namaMenu);
        total_text.setText("Rp. "+totalText);
        jumlah_pesan.setText(jumlahPesan+" Porsi");
    }
}