package com.example.a03basicappdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityEntryData extends AppCompatActivity implements View.OnClickListener {

    EditText ekode, enama, esks, esyarat;
    Button saveButton, viewButton;

    DatabaseHelper dbh;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_entry_data);

        ekode = findViewById(R.id.kodeEdit);
        enama = findViewById(R.id.namaEdit);
        esks = findViewById(R.id.sksEdit);
        esyarat = findViewById(R.id.syaratEdit);

        saveButton = findViewById(R.id.saveButton);
        viewButton = findViewById(R.id.viewButton);

        dbh = new DatabaseHelper(this);

        saveButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.saveButton){
            String xkode = ekode.getText().toString();
            String xnama = enama.getText().toString();
            String xsks = esks.getText().toString();
            String xsyarat = esyarat.getText().toString();

            boolean hasil = dbh.input_matakuliah(xkode, xnama, xsks, xsyarat);
            if(hasil){
                Toast.makeText(this, "Save Successfull!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Save Successfull!", Toast.LENGTH_SHORT).show();
            }

            ekode.setText("");
            enama.setText("");
            esks.setText("");
            esyarat.setText("");

        }else {
            Intent intent = new Intent(MainActivityEntryData.this, MainActivity.class);
            startActivity(intent);
        }
    }
}