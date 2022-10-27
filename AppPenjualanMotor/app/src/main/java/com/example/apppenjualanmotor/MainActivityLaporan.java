package com.example.apppenjualanmotor;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityLaporan extends AppCompatActivity {
    ListView listView;
    DatabaseHelper dbh;
    ArrayList<String> listitem;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_laporan);
        listView=findViewById(R.id.list);
        dbh = new DatabaseHelper(this);
        listitem=new ArrayList<>();


        Cursor cursor = dbh.bacadata();
        listitem.clear();
        while (cursor.moveToNext()){
            listitem.add("| Gambar : " + cursor.getString(0) + " | Nama Barang : " + cursor.getString(1) + " | Harga : " + cursor.getString(4) + " " +cursor.getString(2) + " | Harga : Rp" + cursor.getString(3) + " | terjual : " + cursor.getString(6) + " | sisa : " + cursor.getString(7));
        }
        adapter = new ArrayAdapter(MainActivityLaporan.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listitem);
        listView.setAdapter(adapter);

    }
}