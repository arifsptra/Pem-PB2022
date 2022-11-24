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
        Context context=parent.getContext();
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.format_matkul,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
         holder.mkode.setText(matakuliahArrayList.get(position).getKode());
         holder.mnama.setText(matakuliahArrayList.get(position).getNama_mtkl());
         holder.msks.setText(matakuliahArrayList.get(position).getSks());
    }

    @Override
    public int getItemCount() {
        return matakuliahArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView mkode,mnama,msks;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            mkode=itemView.findViewById(R.id.kodematkul);
            mnama=itemView.findViewById(R.id.nmmatkul);
            msks=itemView.findViewById(R.id.sksmatkul);

        }
    }
}
