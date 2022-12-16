package com.example.firebasebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText enip, enama, ejenis, estatus, ependidikan, ealamat, ekota;
    Button bsave, bview;

    DatabaseReference dbf;
    MakuliahModel mkm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enip = findViewById(R.id.edit_nip);
        enama = findViewById(R.id.edit_nama);
        ejenis = findViewById(R.id.edit_jk);
        estatus = findViewById(R.id.edit_status);
        ependidikan = findViewById(R.id.edit_pendidikan);
        ealamat = findViewById(R.id.edit_alamat);
        ekota = findViewById(R.id.edit_kota);

        bview = findViewById(R.id.button_view);

        mkm = new MakuliahModel();

        bsave = findViewById(R.id.button_save);

        dbf = FirebaseDatabase.getInstance().getReference().child("Akademik");

        bsave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mkm.setNip(enip.getText().toString());
                mkm.setNama_pegawai(enama.getText().toString());
                mkm.setJenis_kel(ejenis.getText().toString());
                mkm.setStatus(estatus.getText().toString());
                mkm.setPendidikan(ependidikan.getText().toString());
                mkm.setAlamat(ealamat.getText().toString());
                mkm.setKota(ekota.getText().toString());

                dbf.push().setValue(mkm);
            }
        });

        bview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainFB.class);
                startActivity(intent);
            }
        });
    }
}