package com.example.a03basicappdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    Button inputButton;
    ArrayList<ModelMatakuliah> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        inputButton = findViewById(R.id.inputButton);

        inputButton.setOnClickListener(this);

        DatabaseHelper dbh = new DatabaseHelper(this);

        /*
        String xkode = "01";
        String xnama = "Arif";
        String xsks = "144";
        String xsyarat = "tidak ada";

        boolean hasil = dbh.input_matakuliah(xkode, xnama, xsks, xsyarat);

        if(hasil){
            Toast.makeText(this, "Save Successfull!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Save Successfull!", Toast.LENGTH_SHORT).show();
        }
         */

        Cursor cursor = dbh.baca_matakuliah();

        while (cursor.moveToNext()){
            arrayList.add(new ModelMatakuliah(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3) ));
        }

        AdapterMatakuliah adapterMatakuliah = new AdapterMatakuliah(this, arrayList);
        recyclerView.setAdapter(adapterMatakuliah);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.inputButton){
            Intent intent = new Intent(MainActivity.this, MainActivityEntryData.class);
            startActivity(intent);
        }
    }
}