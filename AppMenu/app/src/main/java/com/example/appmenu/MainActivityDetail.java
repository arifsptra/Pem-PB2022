package com.example.appmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.time.Instant;

public class MainActivityDetail extends AppCompatActivity {

    TextView nama_menu;
    TextView harga_menu;
    TextView satuan_menu;
    TextView count_text;
    TextView total_text;
    Button btn_minus, btn_plus, btn_beli;
    ImageView image_menu;
    int jumlah=0;
    int priceView=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        nama_menu = findViewById(R.id.nama_menu);
        harga_menu = findViewById(R.id.harga_menu);
        satuan_menu = findViewById(R.id.satuan_menu);
        image_menu = findViewById(R.id.image_menu);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        btn_beli = findViewById(R.id.btn_beli);
        count_text = findViewById(R.id.count_text);
        total_text = findViewById(R.id.total_text);

        getIncomingExtra();

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hargaSatuan = harga_menu.getText().toString();
                int basePrice = Integer.parseInt(hargaSatuan);
                jumlah++;
                total_text();
                priceView = basePrice*jumlah;
                String setnewPrice = String.valueOf(priceView);
                total_text.setText("Rp. "+setnewPrice);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hargaSatuan = harga_menu.getText().toString();
                int basePrice = Integer.parseInt(hargaSatuan);
                if(jumlah==0){
                }else{
                    jumlah--;
                    total_text();
                    priceView = basePrice*jumlah;
                    String setnewPrice = String.valueOf(priceView);
                    total_text.setText("Rp. "+setnewPrice);
                }
            }
        });

        btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaMenu = nama_menu.getText().toString();
                String totalHarga = String.valueOf(priceView);
                String jumlahPesan = String.valueOf(jumlah);
                String hargaAwal = harga_menu.getText().toString();
                Intent intent = new Intent(MainActivityDetail.this, MainActivityBeli.class);
                intent.putExtra("nama_menu", namaMenu);
                intent.putExtra("total_harga", totalHarga);
                intent.putExtra("jumlah_pesan", jumlahPesan);
                intent.putExtra("harga_awal", hargaAwal);
                startActivity(intent);
            }
        });
    }

    private void getIncomingExtra() {
        if(getIntent().hasExtra("nama_menu") && getIntent().hasExtra("harga_menu") && getIntent().hasExtra("satuan_menu") && getIntent().hasExtra("image_menu")){
            String namaMenu = getIntent().getStringExtra("nama_menu");
            String hargaMenu = getIntent().getStringExtra("harga_menu");
            String satuanMenu = getIntent().getStringExtra("satuan_menu");
            int imageMenu = getIntent().getIntExtra("image_menu",1);

            setDataActivity(namaMenu, hargaMenu, satuanMenu, imageMenu);
        }
    }

    private void setDataActivity(String namaMenu, String hargaMenu, String satuanMenu, int imageMenu) {
        nama_menu.setText(namaMenu);
        harga_menu.setText(hargaMenu);
        satuan_menu.setText(satuanMenu);
        image_menu.setImageResource(imageMenu);
    }

    private void total_text(){ count_text.setText(String.valueOf(jumlah));}



}