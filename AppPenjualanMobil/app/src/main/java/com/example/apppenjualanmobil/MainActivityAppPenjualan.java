package com.example.apppenjualanmobil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivityAppPenjualan extends AppCompatActivity {

    ArrayList<modelApp> menuArrayList=new ArrayList<>();
    RecyclerView recyclerView;

    String namaMobil[] = {"Toyota Rush", "Honda HR-V", "Wuling Almaz", "Toyota Corolla Cross", "Suzuki XL7", "Hyundai Kona Electric", "Mitsubishi Pajero", "Toyota Fortuner", "Honda CR-V", "BMW X-1"};
    String kodeMobil[] = {"MTR01", "MHRV02", "MWA03", "TCC04", "MSX05", "MHK06", "MMPS07", "MTF08", "MHCRV09", "MBMWX10"};
    String satuanMobil[] = {"/Unit", "/Unit","/Unit","/Unit","/Unit","/Unit","/Unit","/Unit","/Unit","/Unit"};
    String hargaMobil[] = {"400000000", "500000000", "650000000", "930000000", "782000000", "4350000000", "12000000", "545000000", "670000000", "906000000"};
    int imageMobil[] = {R.drawable.mobil1,R.drawable.mobil2,R.drawable.mobil3,R.drawable.mobil4,R.drawable.mobil5,R.drawable.mobil6,R.drawable.mobil7,R.drawable.mobil8,R.drawable.mobil9,R.drawable.mobil10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app_penjualan);

        recyclerView = findViewById(R.id.recyclerview);

        bacadata();
        AppAdapter appAdapter=new AppAdapter(menuArrayList,this);
        recyclerView.setAdapter(appAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(MainActivityAppPenjualan.this, 2));
    }

    private void bacadata(){
        for(int i=0; i<namaMobil.length; i++){
            menuArrayList.add(new modelApp(namaMobil[i],
                    kodeMobil[i], satuanMobil[i],
                    hargaMobil[i], imageMobil[i]));
        }
    }
}