package com.example.apppenjualanmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityDetail extends AppCompatActivity {

    TextView nama_mobil, kode_mobil, satuan_mobil, harga_mobil, count, total;
    ImageView image_mobil;
    EditText nama_pembeli;
    Button btn_minus, btn_plus, btn_beli;
    int jumlah=0;
    int priceView=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        nama_mobil = findViewById(R.id.namaMobilText);
        kode_mobil = findViewById(R.id.kodeMobilText);
        satuan_mobil = findViewById(R.id.satuanMobilText);
        harga_mobil = findViewById(R.id.hargaMobilText);
        image_mobil = findViewById(R.id.mobilImageView);
        nama_pembeli = findViewById(R.id.namaPelangganEditText);
        btn_beli = findViewById(R.id.btn_beli);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        count = findViewById(R.id.count_text);
        total = findViewById(R.id.total_text);

        getIncomingExtra();

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hargaSatuan = harga_mobil.getText().toString();
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
                String hargaSatuan = harga_mobil.getText().toString();
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
                String namaMobil = nama_mobil.getText().toString();
                String totalHarga = String.valueOf(priceView);
                String kodeMobil = kode_mobil.getText().toString();
                String jumlahPesan = String.valueOf(jumlah);
                String hargaAwal = harga_mobil.getText().toString();
                String namaPelanggan = nama_pembeli.getText().toString();
                Intent intent = new Intent(MainActivityDetail.this, MainActivityBeli.class);
                intent.putExtra("nama_pelanggan", namaPelanggan);
                intent.putExtra("nama_mobil", namaMobil);
                intent.putExtra("kode_mobil", kodeMobil);
                intent.putExtra("total_harga", totalHarga);
                intent.putExtra("jumlah_pesan", jumlahPesan);
                intent.putExtra("harga_awal", hargaAwal);
                startActivity(intent);
            }
        });
    }

    private void getIncomingExtra() {
        if(getIntent().hasExtra("nama_mobil") && getIntent().hasExtra("kode_mobil") && getIntent().hasExtra("satuan_mobil") && getIntent().hasExtra("harga_mobil") && getIntent().hasExtra("image_mobil")){
            String namaMobil = getIntent().getStringExtra("nama_mobil");
            String kodeMobil = getIntent().getStringExtra("kode_mobil");
            String satuanMobil = getIntent().getStringExtra("satuan_mobil");
            String hargaMobil = getIntent().getStringExtra("harga_mobil");
            int imageMobil = getIntent().getIntExtra("image_mobil",1);

            setDataActivity(namaMobil, kodeMobil, satuanMobil , hargaMobil, imageMobil);
        }
    }

    private void setDataActivity(String namaMobil, String kodeMobil, String satuanMobil, String hargaMobil, int imageMobil) {
        nama_mobil.setText(namaMobil);
        kode_mobil.setText(kodeMobil);
        satuan_mobil.setText(satuanMobil);
        harga_mobil.setText(hargaMobil);
        image_mobil.setImageResource(imageMobil);
    }

    private void total_harga(){ count.setText(String.valueOf(jumlah));}
}