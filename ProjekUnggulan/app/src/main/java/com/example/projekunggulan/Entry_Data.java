package com.example.projekunggulan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Entry_Data extends AppCompatActivity implements View.OnClickListener {
    EditText ekode,enama,esks,esyarat;
    Button btnsave,btnview;
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data);
        ekode=findViewById(R.id.editkode);
        enama=findViewById(R.id.editnama);
        esks=findViewById(R.id.editsks);
        esyarat=findViewById(R.id.editsyarat);
        dbh=new DatabaseHelper(this);
        btnsave=findViewById(R.id.buttonsave);
        btnview=findViewById(R.id.buttonview);
        btnsave.setOnClickListener(this);
        btnview.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.buttonsave)
        {
            String xkode=ekode.getText().toString();
            String xnama=enama.getText().toString();
            String xsks=esks.getText().toString();
            String xsyarat=esyarat.getText().toString();

        boolean hasil=dbh.input_matakuliah(xkode,xnama,xsks,xsyarat);
        if(hasil)
            {
                Toast.makeText(this, "Save Sucessfull !", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(this, "Save not Sucess !", Toast.LENGTH_SHORT).show();
            }

        ekode.setText("");
        enama.setText("");
        esks.setText("");
        esyarat.setText("");

        }else{
            Intent intent=new Intent(Entry_Data.this,BacaSqlite.class);
            startActivity(intent);
        }

    }
}