package com.example.a01basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    TextView result;
    EditText num1, num2;
    Button addition;
    int number1, number2, getResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        addition = findViewById(R.id.add);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mengambil nilai pada kolom input menjadi angka
                number1 = Integer.parseInt(num1.getText().toString());
                number2 = Integer.parseInt(num2.getText().toString());
                // operasi aritmatika biasa
                getResult = number1 + number2;
                // menampilkan hasil
                result.setText(String.valueOf(getResult));

            }

        });
    }
}