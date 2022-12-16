package com.example.firebasebasic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterMatakuliah extends RecyclerView.Adapter<AdapterMatakuliah.viewholder> {
    Activity activity;
    ArrayList<MakuliahModel> modelDataMatakulArrayList;
    DatabaseReference dbf;

    public AdapterMatakuliah(Activity activity, ArrayList<MakuliahModel> modelDataMatakulArrayList) {
        this.activity = activity;
        this.modelDataMatakulArrayList = modelDataMatakulArrayList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(activity);
        View view=inflater.inflate(R.layout.activity_tampil_data,parent,false);
        return new AdapterMatakuliah.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.cnip.setText("Kode\t\t\t:"+modelDataMatakulArrayList.get(position).getNip());
        holder.cnama.setText("Nama\t\t:"+modelDataMatakulArrayList.get(position).getNama_pegawai());
        holder.cjenis.setText("Sks\t\t\t\t:"+modelDataMatakulArrayList.get(position).getJenis_kel());
        holder.cstatus.setText("Sks\t\t\t\t:"+modelDataMatakulArrayList.get(position).getStatus());
        holder.cpendidikan.setText("Sks\t\t\t\t:"+modelDataMatakulArrayList.get(position).getPendidikan());
        holder.calamat.setText("Sks\t\t\t\t:"+modelDataMatakulArrayList.get(position).getAlamat());
        holder.ckota.setText("Sks\t\t\t\t:"+modelDataMatakulArrayList.get(position).getKota());
        holder.hapusimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activity, "Test", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder=new AlertDialog.Builder(activity);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MakuliahModel modelDataMatakul=new MakuliahModel();
                        dbf= FirebaseDatabase.getInstance().getReference();
//                        Toast.makeText(activity, ""+modelDataMatakulArrayList.get(position).getKode(), Toast.LENGTH_SHORT).show();
                        dbf.child("Akademik").child(modelDataMatakulArrayList.get(position).getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setMessage(" Yakin data dihapus ?");
                builder.show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return modelDataMatakulArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView cnip, cnama, cjenis, cstatus, cpendidikan, calamat, ckota;
        ImageView hapusimage;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            cnip=itemView.findViewById(R.id.tnip);
            cnama=itemView.findViewById(R.id.tnama);
            cjenis=itemView.findViewById(R.id.tjenis);
            cstatus=itemView.findViewById(R.id.tstatus);
            cpendidikan=itemView.findViewById(R.id.tpendidikan);
            calamat=itemView.findViewById(R.id.talamat);
            ckota=itemView.findViewById(R.id.tkota);
            hapusimage=itemView.findViewById(R.id.hapus);
        }
    }
}
