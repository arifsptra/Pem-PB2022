package com.example.projekunggulan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView gambare;
    TextView nmmenu,hrgmenu,satmenu,totmenu;
    EditText jmlpesan;
    String xnm="nama";
    String tmpnm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nmmenu=findViewById(R.id.nama_menu);
        jmlpesan=findViewById(R.id.jumlah_beli);
        Bundle bundle=getIntent().getExtras();

       xnm =bundle.getString(xnm);
       nmmenu.setText(xnm);
       jmlpesan.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {


           }
       });

    }
}