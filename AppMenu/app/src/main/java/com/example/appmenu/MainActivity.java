package com.example.appmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<modelMenu> menuArrayList=new ArrayList<>();
    RecyclerView recyclerView;

    String namaMenu[] = {"Nasi Goreng", "Nasi Goreng++", "Ayam Geprek", "Ikan Bakar", "Mie Goreng",
    "Jus Jeruk", "Es Teh", "Sate Ayam", "Es Boba", "Kepiting Balado"};
    String hargaMenu[] = {"10000", "15000", "15000", "20000", "10000",
    "5000", "4000", "15000", "10000", "20000"};
    int imageMenu[] = {R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4, R.drawable.menu5,
    R.drawable.menu6, R.drawable.menu7, R.drawable.menu8, R.drawable.menu9, R.drawable.menu10};
    String satuanMenu[] = {"/porsi", "/porsi", "/porsi", "/ekor", "/porsi", "/gelas", "/gelas", "/5 tusuk", "/gelas", "/ekor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview_menu);

        bacadata_menu();
        MenuAdapter menuAdapter=new MenuAdapter(menuArrayList,this);
        recyclerView.setAdapter(menuAdapter);

        //RecyclerView.LayoutManager;
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    private void bacadata_menu(){
        for(int i=0; i<namaMenu.length; i++){
            menuArrayList.add(new modelMenu(namaMenu[i],
                    hargaMenu[i],
                    satuanMenu[i],
                    imageMenu[i]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_list:
                Toast.makeText(this, "Item list selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_grid:
                Toast.makeText(this, "Item grid selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}