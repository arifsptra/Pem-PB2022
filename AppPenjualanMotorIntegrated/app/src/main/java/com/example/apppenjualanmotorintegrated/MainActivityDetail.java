package com.example.apppenjualanmotorintegrated;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivityDetail extends AppCompatActivity {

    DatabaseHelper dbh;
    TextView count, total;
    TextView showKode, showNama, showSatuan, showHarga, showStok;
    EditText namaPelangganText, pekerjaanPelangganText, alamatPelangganText;
    Button btn_minus, btn_plus, btn_beli;
    ImageView showGambar;
    String sisaStok, id;
    int sisaStokInt;
    //    int hargaMotor = Integer.parseInt(String.valueOf(showHarga));
    int jumlah = 0;
    int priceView = 0;
    String satuan = "unit";

    //
    ListView listView;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);



//        tombol_input.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, InputData.class);
//                startActivity(intent);
//            }
//        });



//        showKode = findViewById(R.id.kodeMotorText);
//        showNama = findViewById(R.id.namaMotorText);
//        showSatuan = findViewById(R.id.satuanMotorText);
//        showHarga = findViewById(R.id.hargaMotorText);
//        showStok = findViewById(R.id.sisaStok);
//        showGambar = findViewById(R.id.gambarMotorImage);
//        //
//        namaPelangganText = findViewById(R.id.namaPelangganEditText);
//        pekerjaanPelangganText = findViewById(R.id.pekerjaanPelangganEditText);
//        alamatPelangganText = findViewById(R.id.alamatPelangganEditText);
//        //
//        count = findViewById(R.id.count_text);
//        total = findViewById(R.id.totalBeli);
//        btn_plus = findViewById(R.id.btn_plus);
//        btn_minus = findViewById(R.id.btn_minus);
//        btn_beli = findViewById(R.id.btn_beli);

//        getIncomingExtra();

//        getData();
    }
//    private void getData(){
//
//        SQLiteDatabase ReadData = dbh.getReadableDatabase();
//        Cursor cursor = ReadData.rawQuery("SELECT * FROM " + DatabaseHelper.MyColumns.NamaTabel + " WHERE " + DatabaseHelper.MyColumns.KodeMotor + "=" + id, null);
//
//        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal
//        if(cursor.moveToFirst()){
//            @SuppressLint("Range") String kode = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MyColumns.KodeMotor));
//            @SuppressLint("Range") String nama = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MyColumns.NamaMotor));
//            @SuppressLint("Range") String satuan = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MyColumns.SatuanMotor));
//            @SuppressLint("Range") Double harga = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.MyColumns.HargaMotor));
//            @SuppressLint("Range") String stok = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MyColumns.StokMotor));
//            @SuppressLint("Range") String gambar = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MyColumns.GambarMotor));
//
//            showKode.setText(kode);
//            showNama.setText(nama);
//            showSatuan.setText(satuan);
//            showStok.setText(stok);
//            showHarga.setText(formatRupiah.format((double)harga));
//            showGambar.setImageURI(Uri.parse(gambar));
//        }
//    }
//    private void getIncomingExtra() {
//        if(getIntent().hasExtra("kode_motor") && getIntent().hasExtra("nama_motor") && getIntent().hasExtra("satuan_motor") && getIntent().hasExtra("harga_motor") && getIntent().hasExtra("stok_harga")){
//            String kode_motor = getIntent().getStringExtra("kode_motor");
//            String nama_motor = getIntent().getStringExtra("nama_motor");
//            String satuan_motor = getIntent().getStringExtra("satuan_motor");
//            int harga_motor = getIntent().getIntExtra("harga_motor", 0);
//            String stok_motor = getIntent().getStringExtra("stok_motor");
//    //        int gambar_motor = getIntent().getIntExtra("gambar_motor",0);
//
//            setDataActivity(kode_motor, nama_motor, satuan_motor, harga_motor, stok_motor);
//        }
//    }
//
//    private void setDataActivity(String kodeMotor, String namaMotor, String satuanMotor, int hargaMotor, String stokMotor) {
//        showKode.setText(kodeMotor);
//        showNama.setText("coba nih ye");
//        showSatuan.setText(satuanMotor);
//        showHarga.setText(hargaMotor);
//        showStok.setText(stokMotor);
////        showGambar.setImageResource(gambar_motor);
//    }

//    private void total_harga(){ count.setText(String.valueOf(jumlah));}
}