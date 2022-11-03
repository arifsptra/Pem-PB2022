package com.example.appperpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;


public class DetailActivity extends AppCompatActivity {

    private DbBook MyDatabase;
    private TextView ShowKode, ShowJudul, ShowPembaca, ShowRating, ShowPenerbit, ShowDeskripsi, ShowHarga;
    private ImageView ShowImage, Back;
    private String Id ;
    private Button Update;
    private String KodeSend = "KODE";
    private String sendVal = "id";
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MyDatabase = new DbBook(getBaseContext());

        Update =    findViewById(R.id.update);
        Back = findViewById(R.id.back);
        ShowKode = findViewById(R.id.KodeText);
        ShowImage = findViewById(R.id.imageDetail);
        ShowJudul = findViewById(R.id.judulBukuDetail);
        ShowPembaca = findViewById(R.id.BoxPembaca);
        ShowRating = findViewById(R.id.BoxRating);
        ShowPenerbit = findViewById(R.id.PenerbitDetail);
        ShowDeskripsi = findViewById(R.id.DeskripsiText);
        ShowHarga = findViewById(R.id.HargaDetail);

        getData();

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Kode = ShowKode.getText().toString();
                if (Kode != null && Kode != ""){
                    Intent i = new Intent(DetailActivity.this, UpdateActivity.class);
                    i.putExtra(KodeSend, Kode);
                    startActivity(i);

                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Kode = ShowKode.getText().toString();
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                intent.putExtra(sendVal,Kode);
                startActivity(intent);
            }
        });


    }
    private void getData(){

        SQLiteDatabase ReadData = MyDatabase.getReadableDatabase();
        Cursor cursor = ReadData.rawQuery("SELECT * FROM " + DbBook.MyColumns.NamaTabel + " WHERE " + DbBook.MyColumns.KodeBuku + "=" + Id, null);

        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal
        if(cursor.moveToFirst()){
            @SuppressLint("Range") String Kode = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.KodeBuku));
            @SuppressLint("Range") String Judul = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Judul));
            @SuppressLint("Range") String Pembaca = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Pembaca));
            @SuppressLint("Range") String Rating = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Rating));
            @SuppressLint("Range") String Penerbit = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Penerbit));
            @SuppressLint("Range") String Deskripsi = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Deskripsi));
            @SuppressLint("Range") Double Harga = cursor.getDouble(cursor.getColumnIndex(DbBook.MyColumns.Harga));
            @SuppressLint("Range") String Foto = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Foto));

            ShowKode.setText(Kode);
            ShowJudul.setText(Judul);
            ShowPembaca.setText(Pembaca);
            ShowRating.setText(Rating);
            ShowPenerbit.setText(Penerbit);
            ShowDeskripsi.setText(Deskripsi);
            ShowHarga.setText(formatRupiah.format((double)Harga));
            ShowImage.setImageURI(Uri.parse(Foto));
        }
    }
}