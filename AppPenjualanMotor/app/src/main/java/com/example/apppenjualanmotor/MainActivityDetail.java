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

    DatabaseHelper dbh;
    TextView namaMotorText, kodeMotorText, hargaMotorText, count, total, stok;
    EditText namaPelangganText, pekerjaanPelangganText, alamatPelangganText;
    Button btn_minus, btn_plus, btn_beli;
    ImageView gambarMotorImage;
    String sisaStok;
    int sisaStokInt;
    int hargaMotor;
    int jumlah=0;
    int priceView=0;
    String satuan = "unit";

    DecimalFormat formatter = new DecimalFormat("#,###");

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
        stok = findViewById(R.id.sisaStok);
        count = findViewById(R.id.count_text);
        total = findViewById(R.id.totalBeli);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_beli = findViewById(R.id.btn_beli);
        dbh = new DatabaseHelper(this);

        getIncomingExtra();

        sisaStok = stok.getText().toString();
        sisaStokInt = Integer.valueOf(sisaStok);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int basePrice = hargaMotor;
                jumlah++;
                total_harga();
                priceView = basePrice*jumlah;
                total.setText("Rp. "+formatter.format(priceView));
                sisaStokInt-=1;
                stok.setText(String.valueOf(sisaStokInt));
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int basePrice = hargaMotor;
                if(jumlah==0){
                }else{
                    jumlah--;
                    total_harga();
                    priceView = basePrice*jumlah;
                    total.setText("Rp. "+formatter.format(priceView));
                    sisaStokInt+=1;
                    stok.setText(String.valueOf(sisaStokInt));
                }
            }
        });

        btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gambarMotor = gambarMotorImage.getResources().toString();
                String namaMotor = namaMotorText.getText().toString();
                String totalHarga = String.valueOf(priceView);
                String jumlahPesan = String.valueOf(jumlah);
                String hargaAwal = hargaMotorText.getText().toString();
                String namaPelanggan = namaPelangganText.getText().toString();
                String pekerjaanPelanggan = pekerjaanPelangganText.getText().toString();
                String alamatPelanggan = alamatPelangganText.getText().toString();
                String totalBayar = String.valueOf(priceView+(priceView*10/100));
                dbh = new DatabaseHelper(MainActivityDetail.this);
                dbh.tambahdata(hargaAwal, namaMotor, satuan, kodeMotorText.getText().toString(), 1, priceView, jumlahPesan, 100);
                Intent intent = new Intent(MainActivityDetail.this, MainActivityCetakPesanan.class);
                intent.putExtra("gambar_motor", gambarMotor);
                intent.putExtra("nama_pelanggan", namaPelanggan);
                intent.putExtra("pekerjaan_pelanggan", pekerjaanPelanggan);
                intent.putExtra("alamat_pelanggan", alamatPelanggan);
                intent.putExtra("nama_motor", namaMotor);
                intent.putExtra("total_harga", totalHarga);
                intent.putExtra("jumlah_pesan", jumlahPesan);
                intent.putExtra("harga_awal", hargaAwal);
                intent.putExtra("total_bayar", totalBayar);
                intent.putExtra("sisa_stok", sisaStok);
                intent.putExtra("stok_motor", stok.getText().toString());
                startActivity(intent);
            }
        });
    }
    private void getIncomingExtra() {
        if(getIntent().hasExtra("nama_motor") && getIntent().hasExtra("kode_motor") && getIntent().hasExtra("harga_motor") && getIntent().hasExtra("stok_motor") && getIntent().hasExtra("tampilan_harga") && getIntent().hasExtra("gambar_motor")){
            String nama_motor = getIntent().getStringExtra("nama_motor");
            String kode_motor = getIntent().getStringExtra("kode_motor");
            int harga_motor = getIntent().getIntExtra("harga_motor", 0);
            int stok_motor = getIntent().getIntExtra("stok_motor",0);
            String tampilan_harga = getIntent().getStringExtra("tampilan_harga");
            int gambar_motor = getIntent().getIntExtra("gambar_motor",0);

            setDataActivity(nama_motor, kode_motor, harga_motor, stok_motor, tampilan_harga, gambar_motor);
        }
    }

    private void setDataActivity(String nama_motor, String kode_motor, int harga_motor, int stok_motor, String tampilan_harga, int gambar_motor) {
        namaMotorText.setText(nama_motor);
        kodeMotorText.setText(kode_motor);
        hargaMotorText.setText(tampilan_harga);
        hargaMotor = harga_motor;
        stok.setText(String.valueOf(stok_motor));
        gambarMotorImage.setImageResource(gambar_motor);
    }

    private void total_harga(){ count.setText(String.valueOf(jumlah));}
}