package com.example.projekunggulan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projekunggulan.Model.MakuliahModel;
import com.example.projekunggulan.R;

import java.util.ArrayList;

public class AdaptorMtkul extends RecyclerView.Adapter<AdaptorMtkul.viewholder> {

    ArrayList<MakuliahModel> matakuliahArrayList;

    public AdaptorMtkul(ArrayList<MakuliahModel> matakuliahArrayList) {
        this.matakuliahArrayList = matakuliahArrayList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.format_matkul, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.nip_pegawai.setText(matakuliahArrayList.get(position).getNip());
        holder.nama_pegawai.setText(matakuliahArrayList.get(position).getNama_pegawai());
        holder.jk_pegawai.setText(matakuliahArrayList.get(position).getJenis_kel());
        holder.status_pegawai.setText(matakuliahArrayList.get(position).getStatus());
        holder.pendidikan_pegawai.setText(matakuliahArrayList.get(position).getPendidikan());
        holder.alamat_pegawai.setText(matakuliahArrayList.get(position).getAlamat());
        holder.kota_pegawai.setText(matakuliahArrayList.get(position).getKota());
    }

    @Override
    public int getItemCount() {
        return matakuliahArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView nip_pegawai, nama_pegawai, jk_pegawai, status_pegawai, pendidikan_pegawai, alamat_pegawai, kota_pegawai;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            nip_pegawai = itemView.findViewById(R.id.NIP);
            nama_pegawai = itemView.findViewById(R.id.namaPegawai);
            jk_pegawai = itemView.findViewById(R.id.jkPegawai);
            status_pegawai = itemView.findViewById(R.id.statusPegawai);
            pendidikan_pegawai = itemView.findViewById(R.id.pendidikanPegawai);
            alamat_pegawai = itemView.findViewById(R.id.alamatPegawai);
            kota_pegawai = itemView.findViewById(R.id.kotaPegawai);
        }
    }
}
