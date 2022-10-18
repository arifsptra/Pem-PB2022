package com.example.appcalculatorvalue;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nilaiTugasET, nilaiUtsET, nilaiUasET;
    Button hitungButton, keluarButton;
    TextView hasilTugasTV, hasilUtsTV, hasilUasTV, hasilAkhirTV, hasilAkhirHurufTV, hasilPredikat;
    int hasil_tugas, hasil_uts, hasil_uas, nilai_akhir;
    String nilai_huruf, predikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilaiTugasET = findViewById(R.id.input_ntugas);
        nilaiUtsET = findViewById(R.id.input_nuts);
        nilaiUasET = findViewById(R.id.input_nuas);

        hitungButton = findViewById(R.id.button_hitung);
        keluarButton = findViewById(R.id.button_keluar);

        hasilTugasTV = findViewById(R.id.htugas);
        hasilUtsTV = findViewById(R.id.huts);
        hasilUasTV = findViewById(R.id.huas);
        hasilAkhirTV = findViewById(R.id.nakhir);
        hasilAkhirHurufTV = findViewById(R.id.nhuruf);
        hasilPredikat = findViewById(R.id.predikat);

        nilaiTugasET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0){
                    hasil_tugas =Integer.parseInt(nilaiTugasET.getText().toString());
                    hasil_tugas = hasil_tugas*30/100;
                    hasilTugasTV.setText(String.valueOf(hasil_tugas));
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        nilaiUtsET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0){
                    hasil_uts =Integer.parseInt(nilaiUtsET.getText().toString());
                    hasil_uts = hasil_uts*35/100;
                    hasilUtsTV.setText(String.valueOf(hasil_uts));
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        nilaiUasET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0){
                    hasil_uas =Integer.parseInt(nilaiUasET.getText().toString());
                    hasil_uas = hasil_uas*35/100;
                    hasilUasTV.setText(String.valueOf(hasil_uas));
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // for N.Akhir
                nilai_akhir = hasil_tugas + hasil_uts + hasil_uas;
                hasilAkhirTV.setText(String.valueOf(nilai_akhir));

                // for N. Huruf
                if (nilai_akhir < 100) {
                    String s = String.valueOf(nilai_akhir);
                    char[] h = new char[2];
                    h[0] = s.charAt(0);
                    h[1] = s.charAt(1);
                    String[] nh = new String[2];
                    for (int i = 0; i < 2; i++) {
                        if (h[i] == '0') {
                            nh[i] = "Kosong";
                        } else if (h[i] == '1') {
                            nh[i] = "Satu";
                        } else if (h[i] == '2') {
                            nh[i] = "Dua";
                        } else if (h[i] == '3') {
                            nh[i] = "Tiga";
                        } else if (h[i] == '4') {
                            nh[i] = "Empat";
                        } else if (h[i] == '5') {
                            nh[i] = "Lima";
                        } else if (h[i] == '6') {
                            nh[i] = "Enam";
                        } else if (h[i] == '7') {
                            nh[i] = "Tujuh";
                        } else if (h[i] == '8') {
                            nh[i] = "Delapan";
                        } else if (h[i] == '9') {
                            nh[i] = "Sembilan";
                        }
                    }
                    nilai_huruf = nh[0] + " " + nh[1];
                } else if (nilai_akhir == 100) {
                    nilai_huruf = "Seratus";
                }
                hasilAkhirHurufTV.setText(nilai_huruf);

                // for Predikat
                if (nilai_akhir >= 85) {
                    predikat = "A";
                } else if (nilai_akhir >= 80) {
                    predikat = "AB";
                } else if (nilai_akhir >= 75) {
                    predikat = "B";
                } else if (nilai_akhir >= 70) {
                    predikat = "BC";
                } else if (nilai_akhir >= 65) {
                    predikat = "C";
                } else if (nilai_akhir >= 50) {
                    predikat = "D";
                } else if (nilai_akhir < 50) {
                    predikat = "E";
                }
                hasilPredikat.setText(predikat);
            }
        });

        keluarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}