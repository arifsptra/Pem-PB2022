package com.example.appmenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter2 extends RecyclerView.Adapter<MenuAdapter2.myViewHolder> {

    ArrayList<modelMenu> arrayList;
    Context context;

    public MenuAdapter2(ArrayList<modelMenu> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MenuAdapter2.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.menu_view_grid, parent, false);
        return new MenuAdapter2.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.cnamamenu.setText(arrayList.get(position).nama_menu);
        holder.chargamenu.setText(arrayList.get(position).harga_menu);
        holder.csatuanmenu.setText(arrayList.get(position).satuan_menu);
        holder.cimagemenu.setImageResource(arrayList.get(position).image_menu);
        holder.listLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nama_menuse = arrayList.get(position).nama_menu;
                String harga_menuse = arrayList.get(position).harga_menu;
                String satuan_menuse = arrayList.get(position).satuan_menu;
                int image_menuse = arrayList.get(position).image_menu;
                Intent intent = new Intent(context, MainActivityDetail.class);

                intent.putExtra("nama_menu", nama_menuse);
                intent.putExtra("harga_menu", harga_menuse);
                intent.putExtra("satuan_menu", satuan_menuse);
                intent.putExtra("image_menu", image_menuse);

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size(); }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout listLayout;
        TextView cnamamenu, chargamenu, csatuanmenu;
        ImageView cimagemenu;
        public myViewHolder(@NonNull View itemView){
            super(itemView);

            listLayout=itemView.findViewById(R.id.grid_layout);
            cnamamenu=itemView.findViewById(R.id.nama_menu);
            chargamenu=itemView.findViewById(R.id.harga_menu);
            csatuanmenu=itemView.findViewById(R.id.satuan_menu);
            cimagemenu=itemView.findViewById(R.id.image_menu);

        }
    }
}
