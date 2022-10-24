package com.example.appherobio;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AdapterHero extends ArrayAdapter {
    String nama_pahlawan[];
    int gambar_pahlawan[];
    String title_pahlawan[];
    Activity activity;

    public AdapterHero(MainActivity activity, String[] nama_pahlawan, int[] gambar_pahlawan, String[] title_pahlawan) {
        super(activity, R.layout.list_item, nama_pahlawan);
        this.nama_pahlawan = nama_pahlawan;
        this.gambar_pahlawan = gambar_pahlawan;
        this.title_pahlawan = title_pahlawan;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item, null);

        ImageView gambar;
        TextView nama;

        gambar=v.findViewById(R.id.hero_image);
        nama=v.findViewById(R.id.hero_name);

        gambar.setImageResource(gambar_pahlawan[position]);
        nama.setText(nama_pahlawan[position]);

        return v;
    }
}
