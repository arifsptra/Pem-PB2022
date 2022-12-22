package com.example.finalproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.API.APIRequestData;
import com.example.finalproject.API.RetrofitServer;
import com.example.finalproject.Activity.Detail;
import com.example.finalproject.Activity.Transaksi;
import com.example.finalproject.Activity.Update;
import com.example.finalproject.Model.DataModelBarang;
import com.example.finalproject.Model.ResponseModelBarang;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.HolderData> {
    private Context context;
    private List<DataModelBarang> listModel;
    private List<DataModelBarang> listBarang;
    private ArrayList<DataModelBarang> arrayList;
    private String idBarang;

    public AdapterBarang(Context context, List<DataModelBarang> listModel) {
        this.context = context;
        this.listModel = listModel;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, @SuppressLint("RecyclerView") int position) {
        DataModelBarang dm = listModel.get(position);

        holder.tvKode.setText(dm.getKode());
        holder.tvNama.setText(dm.getNama());
        holder.tvSatuan.setText(dm.getSatuan());
        holder.tvHarga.setText(dm.getHarga());
        holder.tvStok.setText(dm.getStok());
        holder.tvTerjual.setText(dm.getTerjual());
//        holder.ivGambar.setImageResource(0);
        holder.listLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String varKodeBarang = listModel.get(position).getKode();
                String varNamaBarang = listModel.get(position).getNama();
                String varSatuanBarang = listModel.get(position).getSatuan();
                String varHargaBarang = listModel.get(position).getHarga();
                String varStokBarang = listModel.get(position).getStok();
                String varTerjual = listModel.get(position).getTerjual();

                Intent kirim = new Intent(context, Detail.class);
                kirim.putExtra("xKode", varKodeBarang);
                kirim.putExtra("xNama", varNamaBarang);
                kirim.putExtra("xSatuan", varSatuanBarang);
                kirim.putExtra("xHarga", varHargaBarang);
                kirim.putExtra("xStok", varStokBarang);
                kirim.putExtra("xTerjual", varTerjual);
//                    kirim.putExtra("xGambar", varGambarBarang);
                context.startActivity(kirim);
            }
        });
        holder.listLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder dialogPesan = new AlertDialog.Builder(context);
                dialogPesan.setMessage("Pilih Operasi yang akan dilakukan");
                dialogPesan.setCancelable(true);

                idBarang = holder.tvKode.getText().toString();

                dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteData();
                        dialog.dismiss();
                        ((Transaksi) context).tampilData();
                    }
                });

                dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getData();
                    }
                });

                dialogPesan.show();

                return false;
            }

            private void deleteData(){
                APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
                Call<ResponseModelBarang> hapusData = ardData.ardHapusData(idBarang);

                hapusData.enqueue(new Callback<ResponseModelBarang>() {
                    @Override
                    public void onResponse(Call<ResponseModelBarang> call, Response<ResponseModelBarang> response) {
                        String kode = response.body().getKode();
                        String pesan = response.body().getPesan();

                        Toast.makeText(context, "Kode: "+kode+" | Pesan: "+pesan, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseModelBarang> call, Throwable t) {
                        Toast.makeText(context, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void getData(){
                APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
                Call<ResponseModelBarang> ambilData = ardData.ardGetData(idBarang);

                ambilData.enqueue(new Callback<ResponseModelBarang>() {
                    @Override
                    public void onResponse(Call<ResponseModelBarang> call, Response<ResponseModelBarang> response) {
                        String kode = response.body().getKode();
                        String pesan = response.body().getPesan();

                        listBarang = response.body().getData();

                        String varKodeBarang = listBarang.get(0).getKode();
                        String varNamaBarang = listBarang.get(0).getNama();
                        String varSatuanBarang = listBarang.get(0).getSatuan();
                        String varHargaBarang = listBarang.get(0).getHarga();
                        String varStokBarang = listBarang.get(0).getStok();
//                    String varGambarBarang = listBarang.get(0).getGambar();
                        String varTerjual = listBarang.get(0).getTerjual();

                        Intent kirim = new Intent(context, Update.class);
                        kirim.putExtra("xKode", varKodeBarang);
                        kirim.putExtra("xNama", varNamaBarang);
                        kirim.putExtra("xSatuan", varSatuanBarang);
                        kirim.putExtra("xHarga", varHargaBarang);
                        kirim.putExtra("xStok", varStokBarang);
                        kirim.putExtra("xTerjual", varTerjual);
//                    kirim.putExtra("xGambar", varGambarBarang);
                        context.startActivity(kirim);

                        //Toast.makeText(context, "Kode: "+kode+" | Pesan: "+pesan+, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseModelBarang> call, Throwable t) {
                        Toast.makeText(context, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvKode, tvNama, tvSatuan, tvHarga, tvStok, tvSisaStok, tvTerjual;
//        ImageView ivGambar;
        LinearLayout listLayout;

        public HolderData(@NonNull View v) {
            super(v);

            listLayout = v.findViewById(R.id.list_item);
            tvKode = v.findViewById(R.id.tv_kode);
            tvNama = v.findViewById(R.id.tv_nama);
            tvSatuan = v.findViewById(R.id.tv_satuan);
            tvHarga = v.findViewById(R.id.tv_harga);
            tvStok = v.findViewById(R.id.tv_stok);
//            ivGambar = v.findViewById(R.id.iv_barang);
            tvTerjual = v.findViewById(R.id.tv_terjual);
        }
    }
}

