package com.example.apppenjualanmotor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gotoappButton;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoappButton = findViewById(R.id.gotoappButton);
//        gotostokButton = findViewById(R.id.gotostokButton);
        dbh = new DatabaseHelper(this);

//         String kodeMotor = "HASB";
//         int gambarMotor = R.drawable.motor2;
//         String namaMotor = "BeAT Street";
//         int hargaMotor = 18276000;
//         String satuanMotor = "Unit";
//         int stokMotor = 19;

//         dbh.tambahData(kodeMotor, gambarMotor, namaMotor, hargaMotor, satuanMotor, stokMotor);

        gotoappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityGrid.class);
                startActivity(intent);
            }
        });
//        gotostokButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MainActivityStokMotor.class);
//                startActivity(intent);
//            }
//        });
    }
}