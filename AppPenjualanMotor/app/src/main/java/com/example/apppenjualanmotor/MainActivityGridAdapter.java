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
        holder.cnamamotor.setText(arrayList.get(position).nama_motor);
        holder.ckodemotor.setText(arrayList.get(position).kode_motor);
        holder.chargamotor.setText(arrayList.get(position).harga_motor);
        holder.cgambarmotor.setImageResource(arrayList.get(position).gambar_motor);
        holder.listLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String namaMotor = arrayList.get(position).nama_motor;
                String kodeMotor = arrayList.get(position).kode_motor;
                String hargaMotor = arrayList.get(position).harga_motor;
                int imageMotor = arrayList.get(position).gambar_motor;

                Intent intent = new Intent(context, MainActivityDetail.class);

                intent.putExtra("nama_motor", namaMotor);
                intent.putExtra("kode_motor", kodeMotor);
                intent.putExtra("harga_motor", hargaMotor);
                intent.putExtra("image_motor", imageMotor);

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
