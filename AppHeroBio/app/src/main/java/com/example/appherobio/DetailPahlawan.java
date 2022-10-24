package com.example.appherobio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPahlawan extends AppCompatActivity {

    TextView nama_pahlawan, title_pahlawan, deskripsi_pahlawan;
    ImageView image_pahlawan;

    String namaPahlawan, titlePahlawan, deskripsiPahlawan;
    int imagePahlawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pahlawan);

        Bundle bundle = getIntent().getExtras();

        nama_pahlawan = findViewById(R.id.nama_pahlawan);
        title_pahlawan = findViewById(R.id.title_pahlawan);
        deskripsi_pahlawan = findViewById(R.id.deskripsi_pahlawan);
        image_pahlawan = findViewById(R.id.image_pahlawan);

        namaPahlawan = bundle.getString("nama_pahlawan");
        titlePahlawan = bundle.getString("title_pahlawan");
        deskripsiPahlawan = bundle.getString("deskripsi_pahlawan");
        imagePahlawan = bundle.getInt("image_pahlawan");

        nama_pahlawan.setText(namaPahlawan);
        title_pahlawan.setText(titlePahlawan);
        deskripsi_pahlawan.setText(deskripsiPahlawan);
        image_pahlawan.setImageResource(imagePahlawan);
    }
}