package com.example.appherobio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.appherobio.databinding.ActivityHeroBinding;

public class HeroActivity extends AppCompatActivity{

    ActivityHeroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityHeroBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_hero);

        Intent intent = this.getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");
            String title = intent.getStringExtra("title");
            int imageId = intent.getIntExtra("imageId", R.drawable.a);

            binding.heroName.setText(name);
            binding.heroTitle.setText(title);
            binding.heroImage.setImageResource(imageId);
        }
        }
}
