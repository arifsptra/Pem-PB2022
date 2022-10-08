package com.example.a02basicapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.myViewHolder> {

    ArrayList<modelMenu> arrayList;
    Context context;

    public MenuAdapter(ArrayList<modelMenu> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MenuAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_menu,parent,false);
        return new MenuAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.myViewHolder holder, int position) {
        holder.cnamamenu.setText(arrayList.get(position).nama_menu);
        holder.chargamenu.setText(arrayList.get(position).harga_menu);
        holder.csatuanmenu.setText(arrayList.get(position).satuan_menu);
        holder.cgambarmenu.setImageResource(arrayList.get(position).gambar_menu);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView cnamamenu,csatuanmenu,chargamenu;
        ImageView cgambarmenu;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            cnamamenu=itemView.findViewById(R.id.namamenu);
            csatuanmenu=itemView.findViewById(R.id.satuan);
            chargamenu=itemView.findViewById(R.id.hargamenu);
            cgambarmenu=itemView.findViewById(R.id.gambarmenu);
        }
    }
}
