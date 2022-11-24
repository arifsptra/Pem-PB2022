package com.example.projekunggulan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMatakuliah extends RecyclerView.Adapter<AdapterMatakuliah.myViewHolder> {
    Context context;
    ArrayList<ModelMatakuliah> matakuliahArrayList;

    public AdapterMatakuliah(Context context, ArrayList<ModelMatakuliah> matakuliahArrayList) {
        this.context = context;
        this.matakuliahArrayList = matakuliahArrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_matakuliah,parent,false);
        return new AdapterMatakuliah.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.ckode.setText(matakuliahArrayList.get(position).kode);
        holder.cnama.setText(matakuliahArrayList.get(position).nama_mtkl);
        holder.csks.setText(matakuliahArrayList.get(position).sks);
//        holder.csyarat.setText(matakuliahArrayList.get(position).syarat);

    }

    @Override
    public int getItemCount() {
        return matakuliahArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView ckode,cnama,csks,csyarat;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ckode=itemView.findViewById(R.id.kodemtkul);
            cnama=itemView.findViewById(R.id.namamtkul);
            csks=itemView.findViewById(R.id.sksmtkul);
           // csyarat=itemView.findViewById(R.id.syaratmtkul);
        }
    }
}
