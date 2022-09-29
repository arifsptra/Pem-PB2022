package com.example.appherobio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Hero> {
    public ListAdapter(Context context, ArrayList<Hero> heroArrayList){
        super(context, R.layout.list_item, heroArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Hero hero = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.hero_image);
        TextView heroName = convertView.findViewById(R.id.hero_name);
        TextView heroTitle = convertView.findViewById(R.id.hero_title);

        imageView.setImageResource(hero.imageId);
        heroName.setText(hero.name);
        heroTitle.setText(hero.title);

        return convertView;
    }

}
