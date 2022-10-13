package com.example.appmenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.myViewHolder> {

    ArrayList<modelMenu> arrayList;
    Context context;

    public MenuAdapter(ArrayList<modelMenu> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MenuAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.menu_view_list, parent, false);
        return new MenuAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.myViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.cnamamenu.setText(arrayList.get(position).nama_menu);
        holder.chargamenu.setText(arrayList.get(position).harga_menu);
        holder.csatuanmenu.setText(arrayList.get(position).satuan_menu);
        holder.cimagemenu.setImageResource(arrayList.get(position).image_menu);
        holder.listLayout.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               String nama_menus = arrayList.get(position).nama_menu;
               String harga_menus = arrayList.get(position).harga_menu;
               String satuan_menus = arrayList.get(position).satuan_menu;
               int image_menus = arrayList.get(position).image_menu;
               Intent intent = new Intent(context, MainActivityDetail.class);

               intent.putExtra("nama_menu", nama_menus);
               intent.putExtra("harga_menu", harga_menus);
               intent.putExtra("satuan_menu", satuan_menus);
               intent.putExtra("image_menu", image_menus);

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

            listLayout=itemView.findViewById(R.id.list_layout);
            cnamamenu=itemView.findViewById(R.id.nama_menu);
            chargamenu=itemView.findViewById(R.id.harga_menu);
            csatuanmenu=itemView.findViewById(R.id.satuan_menu);
            cimagemenu=itemView.findViewById(R.id.image_menu);
        }
    }
}
