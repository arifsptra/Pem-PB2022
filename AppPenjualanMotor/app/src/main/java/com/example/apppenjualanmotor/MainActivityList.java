package com.example.apppenjualanmotor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityList extends AppCompatActivity {

    ArrayList<modelApp> menuArrayList=new ArrayList<>();
    RecyclerView recyclerView;

    String kodeMotor[] = {"HASB", "HASBT", "HASG", "HASS", "HASV125", "HASV160", "HASPCX", "HASADV", "HASPCXE", "HASF"};
    String namaMotor[] = {"BeAT", "BeAT Street", "Genio", "Scoopy", "Vario 125", "Vario 160", "PCX", "ADV 160", "PCX e:HEV", "Forza"};
    int hargaMotor[] = {17620000, 18276000, 18880000, 21353000, 22350000, 26339000, 32079000, 36000000, 45045000, 90313000};
    String tampilanHarga[] = {"17620000", "18276000", "18880000", "21353000", "22350000", "26339000", "32079000", "36000000", "45045000", "90313000"};
    int gambarMotor[] = {R.drawable.motor1, R.drawable.motor2, R.drawable.motor3, R.drawable.motor4, R.drawable.motor5, R.drawable.motor6, R.drawable.motor7, R.drawable.motor8, R.drawable.motor9, R.drawable.motor10};
    int stokMotor[] = {37, 19, 21, 43, 18, 34, 25, 41, 23, 11};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        recyclerView = findViewById(R.id.recyclerViewList);

        bacadata();
        MainActivityListAdapter appAdapter=new MainActivityListAdapter(menuArrayList,this);
        recyclerView.setAdapter(appAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivityList.this));
    }

    private void bacadata(){
        for(int i=0; i<namaMotor.length; i++){
            menuArrayList.add(new modelApp(namaMotor[i],
                    kodeMotor[i],
                    hargaMotor[i],
                    stokMotor[i],
                    tampilanHarga[i],
                    gambarMotor[i]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menus,menu);
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
                Intent intent = new Intent(MainActivityList.this, MainActivityGrid.class);
                startActivity(intent);
            case R.id.menu_laporan:
                Toast.makeText(this, "Item grid selected", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivityList.this, MainActivityLaporan.class);
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}