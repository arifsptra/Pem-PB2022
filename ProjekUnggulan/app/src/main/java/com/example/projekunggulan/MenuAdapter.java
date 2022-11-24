package com.example.projekunggulan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.Relatiview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(view.getContext(),MainActivity2.class);
                final Intent intent1 = intent.putExtra("nama", arrayList.get(position).nama_menu);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView cnamamenu,csatuanmenu,chargamenu;
        ImageView cgambarmenu;
        RelativeLayout Relatiview;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            cnamamenu=itemView.findViewById(R.id.namamenu);
            csatuanmenu=itemView.findViewById(R.id.satuan);
            chargamenu=itemView.findViewById(R.id.hargamenu);
            cgambarmenu=itemView.findViewById(R.id.gambarmenu);
            Relatiview=itemView.findViewById(R.id.relatif01);
        }
    }
}
