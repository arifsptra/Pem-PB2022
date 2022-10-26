package com.example.apppenjualanmotor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivityGridAdapter extends RecyclerView.Adapter<MainActivityGridAdapter.myViewHolder>{
    ArrayList<modelApp> arrayList;
    Context context;

    public MainActivityGridAdapter(ArrayList<modelApp> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MainActivityGridAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_main_grid_view, parent, false);
        return new MainActivityGridAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityGridAdapter.myViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        String tampilanHargaMotor = String.valueOf(arrayList.get(position).tampilan_harga);
        holder.cnamamotor.setText(arrayList.get(position).nama_motor);
        holder.ckodemotor.setText(arrayList.get(position).kode_motor);
        holder.chargamotor.setText("Rp. "+formatter.format(Integer.parseInt(tampilanHargaMotor)));
        holder.cgambarmotor.setImageResource(arrayList.get(position).gambar_motor);
        holder.listLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String namaMotor = arrayList.get(position).nama_motor;
                String kodeMotor = arrayList.get(position).kode_motor;
                int hargaMotor = arrayList.get(position).harga_motor;
                int stokMotor = arrayList.get(position).stok_motor;
                String tampilanHarga = arrayList.get(position).tampilan_harga;
                int gambarMotor = arrayList.get(position).gambar_motor;

                Intent intent = new Intent(context, MainActivityDetail.class);

                intent.putExtra("nama_motor", namaMotor);
                intent.putExtra("kode_motor", kodeMotor);
                intent.putExtra("harga_motor", hargaMotor);
                intent.putExtra("stok_motor", stokMotor);
                intent.putExtra("tampilan_harga", "Rp. "+formatter.format(Integer.parseInt(tampilanHarga)));
                intent.putExtra("gambar_motor", gambarMotor);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class myViewHolder extends  RecyclerView.ViewHolder {
        LinearLayout listLayout;
        TextView cnamamotor, ckodemotor, chargamotor;
        ImageView cgambarmotor;
        public myViewHolder(@NonNull View itemView){
            super(itemView);
            listLayout = itemView.findViewById(R.id.grid_layout);
            cnamamotor = itemView.findViewById(R.id.namaMotorText);
            ckodemotor = itemView.findViewById(R.id.kodeMotorText);
            chargamotor = itemView.findViewById(R.id.hargaMotorText);
            cgambarmotor = itemView.findViewById(R.id.gambarMotorImage);
        }
    }
}
