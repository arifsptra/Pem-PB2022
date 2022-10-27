package com.example.belajarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbh;
    ListView listView;
    Button tombol_input;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_item);
        tombol_input = findViewById(R.id.tombol_input);
        dbh = new DatabaseHelper(this);
        listItem = new ArrayList<>();

        // String kodeMotor = "HASB";
        // String namaMotor = "BeAT";

        // dbh.tambahData(kodeMotor, namaMotor);

        Cursor cursor=dbh.baca_data();

        listItem.clear();

        while(cursor.moveToNext()){
            listItem.add(cursor.getString(0)+" "+cursor.getString(1));
        }
        adapter = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listItem);
        listView.setAdapter(adapter);

        tombol_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputData.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, EditData.class);
                String kodeMotorH = (listItem.get(position).substring(0, 4));
                String namaMotorH = (listItem.get(position).substring(5,9));

                intent.putExtra("kode_motor", kodeMotorH);
                intent.putExtra("nama_motor", namaMotorH);

                startActivity(intent);
            }
        });
    }
}