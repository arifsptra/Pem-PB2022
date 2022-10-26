package com.example.apppenjualanmotor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivityDetail extends AppCompatActivity {

    TextView namaMotorText, kodeMotorText, hargaMotorText, count, total;
    EditText namaPelangganText, pekerjaanPelangganText, alamatPelangganText;
    Button btn_minus, btn_plus, btn_beli;
    ImageView gambarMotorImage;
    int jumlah=0;
    int priceView=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        namaMotorText = findViewById(R.id.namaMotorText);
        kodeMotorText = findViewById(R.id.kodeMotorText);
        hargaMotorText = findViewById(R.id.hargaMotorText);
        gambarMotorImage = findViewById(R.id.gambarMotorImage);
        namaPelangganText = findViewById(R.id.namaPelangganEditText);
        pekerjaanPelangganText = findViewById(R.id.pekerjaanPelangganEditText);
        alamatPelangganText = findViewById(R.id.alamatPelangganEditText);
        count = findViewById(R.id.count_text);
        total = findViewById(R.id.totalBeli);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_beli = findViewById(R.id.btn_beli);

        getIncomingExtra();

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hargaSatuan = hargaMotorText.getText().toString();
                int basePrice = Integer.parseInt(hargaSatuan);
                jumlah++;
                total_harga();
                priceView = basePrice*jumlah;
                String setnewPrice = String.valueOf(priceView);
                total.setText("Rp. "+setnewPrice);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hargaSatuan = hargaMotorText.getText().toString();
                int basePrice = Integer.parseInt(hargaSatuan);
                if(jumlah==0){
                }else{
                    jumlah--;
                    total_harga();
                    priceView = basePrice*jumlah;
                    String setnewPrice = String.valueOf(priceView);
                    total.setText("Rp. "+setnewPrice);
                }
            }
        });

        btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaMotor = namaMotorText.getText().toString();
                String totalHarga = String.valueOf(priceView);
                String jumlahPesan = String.valueOf(jumlah);
                String hargaAwal = hargaMotorText.getText().toString();
                String namaPelanggan = namaPelangganText.getText().toString();
                String pekerjaanPelanggan = pekerjaanPelangganText.getText().toString();
                String alamatPelanggan = alamatPelangganText.getText().toString();
                String totalBayar = String.valueOf(priceView+(priceView*10/100));
                Intent intent = new Intent(MainActivityDetail.this, MainActivityCetakPesanan.class);
                intent.putExtra("nama_pelanggan", namaPelanggan);
                intent.putExtra("pekerjaan_pelanggan", pekerjaanPelanggan);
                intent.putExtra("alamat_pelanggan", alamatPelanggan);
                intent.putExtra("nama_motor", namaMotor);
                intent.putExtra("total_harga", totalHarga);
                intent.putExtra("jumlah_pesan", jumlahPesan);
                intent.putExtra("harga_awal", hargaAwal);
                intent.putExtra("total_bayar", totalBayar);
                startActivity(intent);
            }
        });
    }
    private void getIncomingExtra() {
        if(getIntent().hasExtra("nama_motor") && getIntent().hasExtra("kode_motor") && getIntent().hasExtra("harga_motor") && getIntent().hasExtra("gambar_motor")){
            String nama_motor = getIntent().getStringExtra("nama_motor");
            String kode_motor = getIntent().getStringExtra("kode_motor");
            String harga_motor = getIntent().getStringExtra("harga_motor");
            int gambar_motor = getIntent().getIntExtra("gambar_motor",1);

            setDataActivity(nama_motor, kode_motor, harga_motor, gambar_motor);
        }
    }

    private void setDataActivity(String nama_motor, String kode_motor, String harga_motor, int gambar_motor) {
        namaMotorText.setText(nama_motor);
        kodeMotorText.setText(kode_motor);
        hargaMotorText.setText(harga_motor);
        gambarMotorImage.setImageResource(gambar_motor);
    }

    private void total_harga(){ count.setText(String.valueOf(jumlah));}
}