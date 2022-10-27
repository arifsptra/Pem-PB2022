package com.example.belajarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditData extends AppCompatActivity {

    Button tombol_simpan;
    EditText kodeMotor, namaMotor;
    DatabaseHelper dbh;

    String kode_motor, nama_motor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        kodeMotor = findViewById(R.id.kodeMotor);
        namaMotor = findViewById(R.id.namaMotor);
        tombol_simpan = findViewById(R.id.tombol_simpan);

        dbh = new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();

        kode_motor = bundle.getString("kode_motor");
        nama_motor = bundle.getString("nama_motor");

        kodeMotor.setText(kode_motor);
        namaMotor.setText(nama_motor);

        tombol_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.update_data(kodeMotor.getText().toString(), namaMotor.getText().toString());
                Intent intent = new Intent(EditData.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}