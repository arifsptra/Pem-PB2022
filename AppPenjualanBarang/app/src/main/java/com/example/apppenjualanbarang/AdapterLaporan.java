package com.example.apppenjualanbarang;

import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.GAMBAR;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterLaporan extends RecyclerView.Adapter<AdapterLaporan.ViewHolder> {

    Context context;
    List<ModelLaporan> modelNotas;

    public AdapterLaporan(Context context, List<ModelLaporan> modelNotas) {
        this.context = context;
        this.modelNotas = modelNotas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_laporan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (modelNotas != null && modelNotas.size() > 0){
            DecimalFormat formatter = new DecimalFormat("#,###,###");
            ModelLaporan model = modelNotas.get(position);
            holder.kode.setText(model.getKode());
            holder.nama.setText(model.getNama());
            Bitmap image = convertStringToBitmap(model.getGambar());
            holder.gambar.setImageBitmap(image);
            holder.satuan.setText(model.getSatuan());
            holder.stok.setText(model.getStok());
            holder.harga.setText("Rp."+formatter.format(Integer.parseInt(model.getHarga())));
            holder.terjual.setText(model.getTerjual());
            holder.sisa.setText(model.getSisa());
        } else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return modelNotas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView kode,nama,satuan,stok,harga,terjual,sisa;
        ImageView gambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            kode = itemView.findViewById(R.id.kode_nota);
            gambar = itemView.findViewById(R.id.gambar_nota);
            nama = itemView.findViewById(R.id.nama_nota);
            satuan = itemView.findViewById(R.id.satuan_nota);
            stok = itemView.findViewById(R.id.stok_nota);
            harga = itemView.findViewById(R.id.harga_nota);
            terjual = itemView.findViewById(R.id.terjual_nota);
            sisa = itemView.findViewById(R.id.sisa_nota);
        }
    }

    public static Bitmap convertStringToBitmap(String string) {
        byte[] byteArray1;
        byteArray1 = Base64.decode(string, Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray1, 0,
                byteArray1.length);/* w  w  w.ja va 2 s  .  c om*/
        return bmp;
    }

}
