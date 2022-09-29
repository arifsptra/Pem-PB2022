package com.example.a01basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity4 extends AppCompatActivity {

    String bhsprogram[] = {"C", "Java", "Javascript", "PHP", "Python", "Kotlin", "Swift", "Ruby", "C++"};
    ListView tempat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tempat = findViewById(R.id.listviewku);

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity4.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bhsprogram);
        tempat.setAdapter(arrayAdapter);
    }
}