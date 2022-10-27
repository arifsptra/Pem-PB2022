package com.example.belajarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputData extends AppCompatActivity {

    Button tombol_simpan;
    EditText kodeMotor, namaMotor;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        kodeMotor = findViewById(R.id.kodeMotor);
        namaMotor = findViewById(R.id.namaMotor);
        tombol_simpan = findViewById(R.id.tombol_simpan);

        dbh = new DatabaseHelper(this);

        tombol_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.tambahData(kodeMotor.getText().toString(), namaMotor.getText().toString());
                Intent intent = new Intent(InputData.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}