package com.example.applaundry.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applaundry.API.APIRequestData;
import com.example.applaundry.API.RetroServer;
import com.example.applaundry.Activity.MainActivity;
import com.example.applaundry.Activity.UbahActivity;
import com.example.applaundry.Model.DataModel;
import com.example.applaundry.Model.ResponseModel;
import com.example.applaundry.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context context;
    private List<DataModel> listModel;
    private List<DataModel> listLaundry;
    private int idLaundry;

    public AdapterData(Context context, List<DataModel> listModel) {
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
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listModel.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNama.setText(dm.getNama());
        holder.tvAlamat.setText(dm.getAlamat());
        holder.tvTelepon.setText(dm.getTelepon());
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvId, tvNama, tvAlamat, tvTelepon;

        public HolderData(@NonNull View v){
            super(v);

            tvId = v.findViewById(R.id.tv_id);
            tvNama = v.findViewById(R.id.tv_nama);
            tvAlamat = v.findViewById(R.id.tv_alamat);
            tvTelepon = v.findViewById(R.id.tv_telepon);

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(context);
                    dialogPesan.setMessage("Pilih Operasi yang akan dilakukan");
                    dialogPesan.setCancelable(true);

                    idLaundry = Integer.parseInt(tvId.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteData();
                            dialog.dismiss();
                            ((MainActivity) context).retrieveData();
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
            });
        }
        private void deleteData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(idLaundry);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    Toast.makeText(context, "Kode: "+kode+" | Pesan: "+pesan, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(context, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void getData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> ambilData = ardData.ardGetData(idLaundry);

            ambilData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    listLaundry = response.body().getData();

                    int varIdLaundry = listLaundry.get(0).getId();
                    String varNamaLaundry = listLaundry.get(0).getNama();
                    String varAlamatLaundry = listLaundry.get(0).getAlamat();
                    String varTeleponLaundry = listLaundry.get(0).getTelepon();

                    Intent kirim = new Intent(context, UbahActivity.class);
                    kirim.putExtra("xId", varIdLaundry);
                    kirim.putExtra("xNama", varNamaLaundry);
                    kirim.putExtra("xAlamat", varAlamatLaundry);
                    kirim.putExtra("xTelepon", varTeleponLaundry);
                    context.startActivity(kirim);

                    //Toast.makeText(context, "Kode: "+kode+" | Pesan: "+pesan+, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(context, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
