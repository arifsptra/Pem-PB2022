package com.example.apppenjualanmotor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityStokMotor extends AppCompatActivity {

    TextView namaMotorText, sisaStokText, terjualText, stokText;
    ImageView gambarMotorImage;
    int gambarMotor;
    String namaMotor, sisaStok, terjual, stok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stok_motor);

        gambarMotorImage = findViewById(R.id.gambarMotorImage);
        namaMotorText = findViewById(R.id.namaMotorText);
        sisaStokText = findViewById(R.id.sisaStok);
        terjualText = findViewById(R.id.terjual);
        stokText = findViewById(R.id.stok);

        Bundle bundle =getIntent().getExtras();

        namaMotor = bundle.getString("nama_motor");
        gambarMotor = bundle.getInt("gambar_motor", 0);
        sisaStok = bundle.getString("sisa_stok");
        stok = bundle.getString("stok_motor");
        terjual = bundle.getString("terjual");

        gambarMotorImage.setImageResource(gambarMotor);
        namaMotorText.setText(namaMotor);
        sisaStokText.setText(sisaStok);
        stokText.setText(stok);
        terjualText.setText(terjual);
    }
}