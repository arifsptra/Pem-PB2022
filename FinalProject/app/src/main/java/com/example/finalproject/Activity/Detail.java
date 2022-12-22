package com.example.finalproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.API.APIRequestData;
import com.example.finalproject.API.RetrofitServer;
import com.example.finalproject.Model.ResponseModelBarang;
import com.example.finalproject.R;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {

    private String xKode, xNama, xSatuan, xHarga, xStok, xGambar, xTerjual;
    private TextView tvKode, tvNama, tvSatuan, tvHarga, tvStok, tvGambar, count, tvTotal, tvTerjual;
    private Button bUbah;
    private String yKode, yNama, ySatuan, yHarga, yStok, yGambar, yTerjual;
    private EditText etNamaPelanggan, etAlamatPelanggan;
    private Button btn_minus, btn_plus, btn_beli;
    int sisaStokInt;
    int jumlah=0;
    int priceView=0;

//    DecimalFormat formatter = new DecimalFormat("#,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etNamaPelanggan = findViewById(R.id.namaPelangganEditText);
        etAlamatPelanggan = findViewById(R.id.alamatPelangganEditText);

        Intent terima = getIntent();
        xKode = terima.getStringExtra("xKode");
        xNama = terima.getStringExtra("xNama");
        xSatuan = terima.getStringExtra("xSatuan");
        xHarga = terima.getStringExtra("xHarga");
        xStok = terima.getStringExtra("xStok");
//        xGambar = terima.getStringExtra("xGambar");
        xTerjual = terima.getStringExtra("xTerjual");

        tvKode = findViewById(R.id.tv_kode);
        tvNama = findViewById(R.id.tv_nama);
        tvSatuan = findViewById(R.id.tv_satuan);
        tvHarga = findViewById(R.id.tv_harga);
        tvStok = findViewById(R.id.tv_sisa_stok);
        tvTerjual = findViewById(R.id.tv_terjual);
        count = findViewById(R.id.count_text);
        tvTotal = findViewById(R.id.tv_total_harga);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_beli = findViewById(R.id.btn_beli);
//        etGambar = findViewById(R.id.et_gambar);

        tvKode.setText(xKode);
        tvNama.setText(xNama);
        tvSatuan.setText(xSatuan);
        tvHarga.setText(xHarga);
        tvStok.setText(xStok);
        tvTerjual.setText(xTerjual);
//        etGambar.setText(xGambar);

        sisaStokInt = Integer.valueOf(xStok);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int basePrice = Integer.valueOf(xHarga);
                jumlah++;
                total_harga();
                priceView = basePrice*jumlah;
                tvTotal.setText(String.valueOf(priceView));
                sisaStokInt-=1;
                tvStok.setText(String.valueOf(sisaStokInt));
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int basePrice = Integer.valueOf(xHarga);
                if(jumlah==0){
                }else{
                    jumlah--;
                    total_harga();
                    priceView = basePrice*jumlah;
                    tvTotal.setText(String.valueOf(priceView));
                    sisaStokInt+=1;
                    tvStok.setText(String.valueOf(sisaStokInt));
                }
            }
        });

        btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yKode = tvKode.getText().toString();
                yNama = tvNama.getText().toString();
                ySatuan = tvSatuan.getText().toString();
                yHarga = tvHarga.getText().toString();
                yStok = tvStok.getText().toString();
                yTerjual = String.valueOf(Integer.valueOf(tvTerjual.getText().toString())+Integer.valueOf(count.getText().toString()));

                updateData();

                String kodeBarang = tvKode.getText().toString();
                String namaBarang = tvNama.getText().toString();
                String totalBeli = count.getText().toString();
                String hargaAwal = tvHarga.getText().toString();
                String totalBayar = tvTotal.getText().toString();
                String namaPelanggan = etNamaPelanggan.getText().toString();
                String alamatPelanggan = etAlamatPelanggan.getText().toString();

                Intent intent = new Intent(Detail.this, CetakPesanan.class);
                intent.putExtra("kode_barang", kodeBarang);
                intent.putExtra("nama_pelanggan", namaPelanggan);
                intent.putExtra("alamat_pelanggan", alamatPelanggan);
                intent.putExtra("nama_barang", namaBarang);
                intent.putExtra("total_beli", totalBeli);
                intent.putExtra("harga_awal", hargaAwal);
                intent.putExtra("total_bayar", totalBayar);
                startActivity(intent);
            }
        });
    }

    private void total_harga(){ count.setText(String.valueOf(jumlah));}

    private void updateData(){
        APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModelBarang> ubahData = ardData.ardUpdateData(xKode, yNama, ySatuan, yHarga, yStok, yTerjual);

        ubahData.enqueue(new Callback<ResponseModelBarang>() {
            @Override
            public void onResponse(Call<ResponseModelBarang> call, Response<ResponseModelBarang> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();

//                Toast.makeText(Detail.this, "Kode: "+kode+" | Pesan: "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModelBarang> call, Throwable t) {
                Toast.makeText(Detail.this, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}