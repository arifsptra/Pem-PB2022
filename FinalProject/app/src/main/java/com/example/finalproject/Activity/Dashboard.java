package com.example.finalproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalproject.R;

public class Dashboard extends AppCompatActivity {

    Button bKeluar;

    CardView cvAboutme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        bKeluar = findViewById(R.id.bKeluar);
        cvAboutme = findViewById(R.id.cvAboutme);
        bKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Login.class);
                startActivity(intent);
            }
        });
        cvAboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, AboutMe.class);
                startActivity(intent);
            }
        });
    }
}