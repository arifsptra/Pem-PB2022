package com.example.appvaluecalculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nilai_tugas, nilai_uts, nilai_uas;
    Button hitung, keluar;
    TextView hasil_tugas, hasil_uts, hasil_uas, nilai_akhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilai_tugas = (EditText) findViewById(R.id.input_ntugas);
        nilai_uts = (EditText) findViewById(R.id.input_nuts);
        nilai_uas = (EditText) findViewById(R.id.input_nuas);

        hitung = (Button) findViewById(R.id.button_hitung);
        keluar = (Button) findViewById(R.id.button_keluar);

//        double ntugas = Double.parseDouble(nilai_tugas.getText().toString()) * 30 / 100;
//        hasil_tugas.setText(Double.toString(ntugas));
//        double nuts = Double.parseDouble(nilai_uts.getText().toString()) * 35 / 100;
//        hasil_uts.setText(Double.toString(nuts));
//        double nuas = Double.parseDouble(nilai_uas.getText().toString()) * 35 * 100;
//        hasil_uas.setText(Double.toString(nuas));
//
//        hitung.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if((nilai_tugas.getText().length()>0) && (nilai_uts.getText().length()>0) && (nilai_uas.getText().length()>0)){
//                    double result = ntugas + nuts + nuas;
//                    nilai_akhir.setText(Double.toString(result));
//                }
//            }
//        });

    }
}