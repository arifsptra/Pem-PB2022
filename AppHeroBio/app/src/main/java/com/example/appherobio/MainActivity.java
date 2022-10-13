package com.example.appherobio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.appherobio.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageid = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
                R.drawable.e, R.drawable.f, R.drawable.a, R.drawable.h, R.drawable.i,
                R.drawable.j};
        String[] name = {"Ki Hajar Dewantara", "Mohammad Husni Thamrin", "Oeman Said Tjokroaminoto", "Cut Nyak Dhien", "Raden Ajeng Kartini", "Jendral Soedirman", "Pangeran Diponegoro", "Tuanku Imam Bonjol", "I Gusti Ngurah Rai", "Soekarno"};
        String[] title = {"Pahlawan Kemerdekaan Indonesia", "Pahlawan Kemerdekaan Indonesia","Pahlawan Kemerdekaan Indonesia","Pahlawan Kemerdekaan Indonesia","Pahlawan Kemerdekaan Indonesia","Pahlawan Kemerdekaan Indonesia","Pahlawan Nasional", "Pahlawan Nasional", "Pahlawan Nasional", "Pahlawan Nasional"};

        ArrayList<Hero> heroArrayList = new ArrayList<>();
        for(int i=0; i< imageid.length; i++){
            Hero hero = new Hero(name[i], title[i], imageid[i]);
            heroArrayList.add(hero);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this, heroArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent i = new Intent(MainActivity.this, HeroActivity.class);
                i.putExtra("name", name[position]);
                i.putExtra("title", title[position]);
                i.putExtra("imageId", imageid[position]);
                startActivity(i);
            }
        });
    }
}