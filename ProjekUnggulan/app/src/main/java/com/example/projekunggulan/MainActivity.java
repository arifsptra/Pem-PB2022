package com.example.projekunggulan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<modelMenu> menuArrayList=new ArrayList<>();
    RecyclerView recyclerView;

    String nm_menu[]={"Nasi Goreng",
                      "Soto Ayam",
                      "Ayam Bakar",
                       "Nasi Kuning",
                       "Nasi Gudeg",
                       "Nasi Ayam",
                       "Bakso",
                       "Nasi Bubur",
                       "Ayam Geprek"};
    String sat_menu[]={"Piring",
            "Mangkok",
            "Ekor","Bungkus","Bungkus",
            "Mangkok","Mangkok","Piring","Ekor"};
    String hrg_menu[]={"20000",
            "15000","50000",
            "12000",
            "16500",
            "17000",
            "14000",
            "12000",
            "20000"};
    int image_menu[]={R.drawable.menu1,
                      R.drawable.menu2,
                      R.drawable.menu3,
                      R.drawable.menu4,
                      R.drawable.menu5,
                      R.drawable.menu6,
                      R.drawable.menu7,
                      R.drawable.menu8,
                      R.drawable.menu9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview_menu);

        bacadata_menu();
        tampil_listview();

    }



    private void bacadata_menu() {
        for (int i=0;i<nm_menu.length;i++){
            menuArrayList.add(new modelMenu(nm_menu[i],
                          hrg_menu[i],
                          sat_menu[i],
                          image_menu[i]));

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menupil,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item1){
            //Toast.makeText(this, "Anda memilih listview", Toast.LENGTH_SHORT).show();
            tampil_listview();

        }else{
            //Toast.makeText(this, "Anda memilih Gridview", Toast.LENGTH_SHORT).show();
            tampil_gridview();
        }
        return super.onOptionsItemSelected(item);
    }

    private void tampil_gridview() {
        AdapterGrid adapterGrid=new AdapterGrid(menuArrayList,this);
        recyclerView.setAdapter(adapterGrid);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));


    }

    private void tampil_listview() {
        MenuAdapter menuAdapter=new MenuAdapter(menuArrayList,this);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
}