package com.example.projekunggulan;

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

public class BacaSqlite extends AppCompatActivity implements View.OnClickListener {
    Button tblinput;
     RecyclerView recycleviewmkul;
     ArrayList<ModelMatakuliah> matakuliahArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_sqlite);
        recycleviewmkul=findViewById(R.id.recycler_mtkul);
        tblinput=findViewById(R.id.tombolinput);
        tblinput.setOnClickListener(this);
        DatabaseHelper dbh=new DatabaseHelper(this);



        Cursor cursor=dbh.baca_matakuluiah();
        //Toast.makeText(this, ""+cursor.getCount(), Toast.LENGTH_SHORT).show();
        while (cursor.moveToNext()){
             matakuliahArrayList.add(new ModelMatakuliah(cursor.getString(0),
                     cursor.getString(1),
                     cursor.getString(2),
                     cursor.getString(3)));
        }

        AdapterMatakuliah adapterMatakuliah=new AdapterMatakuliah(this, matakuliahArrayList);
        recycleviewmkul.setAdapter(adapterMatakuliah);
        recycleviewmkul.setLayoutManager(new LinearLayoutManager(this));
   }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.tombolinput)
        {
            Intent intent=new Intent(BacaSqlite.this,Entry_Data.class);
            startActivity(intent);
        }
    }
}