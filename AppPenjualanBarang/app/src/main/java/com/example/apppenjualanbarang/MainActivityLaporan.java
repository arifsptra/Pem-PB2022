package com.example.apppenjualanbarang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLaporan extends AppCompatActivity {

    RecyclerView recyclerLaporan;
    AdapterLaporan adapter;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_laporan);

        DB = new DatabaseHelper(this);

        recyclerLaporan = findViewById(R.id.recyclerLaporan);

        setRecyclerView();

    }

    private void setRecyclerView() {
        recyclerLaporan.setHasFixedSize(true);
        recyclerLaporan.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterLaporan(this, DB.getalldata());
        recyclerLaporan.setAdapter(adapter);
    }
}