package com.example.apppenjualanmobil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.myViewHolder>{

    ArrayList<modelApp> arrayList;
    Context context;

    public AppAdapter(ArrayList<modelApp> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public AppAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_grid, parent, false);
        return new AppAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppAdapter.myViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.cnamamobil.setText(arrayList.get(position).nama_mobil);
        holder.ckodemobil.setText(arrayList.get(position).kode_mobil);
        holder.csatuanmobil.setText(arrayList.get(position).satuan_mobil);
        holder.chargamobil.setText(arrayList.get(position).harga_mobil);
        holder.cimagemobil.setImageResource(arrayList.get(position).image_mobil);
        holder.listLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String namaMobil = arrayList.get(position).nama_mobil;
                String kodeMobil = arrayList.get(position).kode_mobil;
                String satuanMobil = arrayList.get(position).satuan_mobil;
                String hargaMobil = arrayList.get(position).harga_mobil;
                int imageMobil = arrayList.get(position).image_mobil;

                Intent intent = new Intent(context, MainActivityDetail.class);

                intent.putExtra("nama_mobil", namaMobil);
                intent.putExtra("kode_mobil", kodeMobil);
                intent.putExtra("satuan_mobil", satuanMobil);
                intent.putExtra("harga_mobil", hargaMobil);
                intent.putExtra("image_mobil", imageMobil);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class myViewHolder extends  RecyclerView.ViewHolder {
        RelativeLayout listLayout;
        TextView cnamamobil, ckodemobil, csatuanmobil, chargamobil;
        ImageView cimagemobil;
        public myViewHolder(@NonNull View itemView){
            super(itemView);
            listLayout = itemView.findViewById(R.id.grid_layout);
            cnamamobil = itemView.findViewById(R.id.namaMobilText);
            ckodemobil = itemView.findViewById(R.id.kodeMobilText);
            csatuanmobil = itemView.findViewById(R.id.satuanMobilText);
            chargamobil = itemView.findViewById(R.id.hargaMobilText);
            cimagemobil = itemView.findViewById(R.id.mobilImageView);
        }
    }
}
