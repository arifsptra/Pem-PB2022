package com.example.apppenjualanmotorintegrated;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivityCetakPesanan extends AppCompatActivity {

    TextView namaPembeliText, pekerjaanPembeliText, alamatPembeliText, beliUnitText, hargaText, jumlahText, totalText, bayarText;
    String namaPembeli, pekerjaanPembeli, alamatPembeli, beliUnit, harga, jumlah, total, bayar, sisaStok, stokMotor;
    Button backHome;
    int gambarMotor;
    DecimalFormat formatter = new DecimalFormat("#,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cetak_pesanan);

        namaPembeliText = findViewById(R.id.namaPembeliText);
        pekerjaanPembeliText = findViewById(R.id.pekerjaanPembeliText);
        alamatPembeliText = findViewById(R.id.alamatPembeliText);
        beliUnitText = findViewById(R.id.beliUnitText);
        hargaText = findViewById(R.id.hargaText);
        jumlahText = findViewById(R.id.jumlahText);
        totalText = findViewById(R.id.totalText);
        bayarText = findViewById(R.id.bayarText);
        backHome = findViewById(R.id.backHome);

        Bundle bundle =getIntent().getExtras();

        namaPembeli = bundle.getString("nama_pelanggan");
        pekerjaanPembeli = bundle.getString("pekerjaan_pelanggan");
        alamatPembeli = bundle.getString("alamat_pelanggan");
        beliUnit = bundle.getString("nama_motor");
        harga = bundle.getString("harga_awal");
        jumlah = bundle.getString("jumlah_pesan");
        total = bundle.getString("total_harga");
        bayar = bundle.getString("total_bayar");
        gambarMotor = bundle.getInt("gambar_motor");
        sisaStok = bundle.getString("sisa_stok");
        stokMotor = bundle.getString("stok_motor");

        namaPembeliText.setText(": "+namaPembeli);
        pekerjaanPembeliText.setText(": "+pekerjaanPembeli);
        alamatPembeliText.setText(": "+alamatPembeli);
        beliUnitText.setText(": "+beliUnit);
        hargaText.setText(": "+harga);
        jumlahText.setText(": "+jumlah+" Buah");
        totalText.setText(": Rp. "+formatter.format(Integer.parseInt(total)));
        bayarText.setText(": Rp. "+formatter.format(Integer.parseInt(bayar)));

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityCetakPesanan.this, MainActivity.class);
                intent.putExtra("gambar_motor", gambarMotor);
                intent.putExtra("nama_motor", beliUnit);
                intent.putExtra("stok_motor", stokMotor);
                intent.putExtra("terjual", String.valueOf(jumlah));
                intent.putExtra("sisa_motor", sisaStok);
                startActivity(intent);
            }
        });
    }
}