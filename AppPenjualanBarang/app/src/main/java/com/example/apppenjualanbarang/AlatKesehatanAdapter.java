package com.example.apppenjualanbarang;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppenjualanbarang.databinding.ItemGridLayoutBinding;
import com.example.apppenjualanbarang.databinding.ItemListLayoutBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AlatKesehatanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ListModeViewHolder listModeViewHolder;
    private GridModeViewHolder gridModeViewHolder;
    private OnItemClickCallback onItemClickCallback;

    public ArrayList<AlatKesehatan> alatKesehatanList = new ArrayList<>();
    private final int LIST_MODE = 0;
    private final int GRID_MODE = 1;
    Boolean isSwitched = true;

    public AlatKesehatanAdapter(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ArrayList<AlatKesehatan> getAlatKesehatanList() {
        return alatKesehatanList;
    }

    public void setAlatKesehatanList(ArrayList<AlatKesehatan> alatKesehatanList) {
        if (alatKesehatanList.size() > 0) {
            this.alatKesehatanList.clear();
        }
        this.alatKesehatanList.addAll(alatKesehatanList);
        notifyDataSetChanged();
    }

    public void addItem(AlatKesehatan alatKesehatan) {
        this.alatKesehatanList.add(alatKesehatan);
        notifyItemInserted(alatKesehatanList.size() - 1);
    }

    public void updateItem(int position, AlatKesehatan alatKesehatan) {
        this.alatKesehatanList.set(position, alatKesehatan);
        notifyItemChanged(position, alatKesehatan);
    }

    public void removeItem(int position) {
        this.alatKesehatanList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, alatKesehatanList.size());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        listModeViewHolder = new ListModeViewHolder(ItemListLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        gridModeViewHolder = new GridModeViewHolder(ItemGridLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

        if (viewType == LIST_MODE) {
            return listModeViewHolder;
        } else {
            return gridModeViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AlatKesehatan alatKesehatan = alatKesehatanList.get(position);
        if (!isSwitched) {
            listModeViewHolder.setItem(alatKesehatan);
            listModeViewHolder.itemView.setOnClickListener(view -> onItemClickCallback.onAlatKesehatanClicked(alatKesehatan, position));
        } else {
            gridModeViewHolder.setItem(alatKesehatan);
            gridModeViewHolder.itemView.setOnClickListener(view -> onItemClickCallback.onAlatKesehatanClicked(alatKesehatan, position));
        }
    }

    @Override
    public int getItemCount() {
        return alatKesehatanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isSwitched) {
            return GRID_MODE;
        } else {
            return LIST_MODE;
        }
    }

    public void toggleViewMode(Boolean isList) {
        isSwitched = isList;
    }

    public static class ListModeViewHolder extends RecyclerView.ViewHolder {
        ItemListLayoutBinding binding;

        public ListModeViewHolder(@NonNull ItemListLayoutBinding b) {
            super(b.getRoot());
            binding = b;
        }

        public void setItem(AlatKesehatan alatKesehatan) {
            DecimalFormat formatter = new DecimalFormat("#,###,###");

            Bitmap bitmap = BitmapFactory.decodeByteArray(Base64.decode(alatKesehatan.gambar, Base64.DEFAULT), 0, Base64.decode(alatKesehatan.gambar, Base64.DEFAULT).length);
            binding.ivAlatKesehatan.setImageBitmap(bitmap);
            binding.tvAlatKesehatanName.setText(alatKesehatan.nama);
            binding.tvKode.setText(alatKesehatan.kode);
            binding.tvSatuan.setText(new StringBuilder(" / 1 " + alatKesehatan.satuan));
            binding.tvHarga.setText(new StringBuilder("Rp " + formatter.format(Integer.parseInt(alatKesehatan.harga))));
            binding.tvStock.setText(new StringBuilder("Stock : " + alatKesehatan.jumlah));
        }
    }

    public static class GridModeViewHolder extends RecyclerView.ViewHolder {
        ItemGridLayoutBinding binding;

        public GridModeViewHolder(@NonNull ItemGridLayoutBinding b) {
            super(b.getRoot());
            binding = b;
        }

        public void setItem(AlatKesehatan alatKesehatan) {
            DecimalFormat formatter = new DecimalFormat("#,###,###");

            Bitmap bitmap = BitmapFactory.decodeByteArray(Base64.decode(alatKesehatan.gambar, Base64.DEFAULT), 0, Base64.decode(alatKesehatan.gambar, Base64.DEFAULT).length);
            binding.ivAlatKesehatan.setImageBitmap(bitmap);
            binding.tvAlatKesehatanName.setText(alatKesehatan.nama);
            binding.tvKode.setText(alatKesehatan.kode);
            binding.tvSatuan.setText(new StringBuilder(" / 1 " + alatKesehatan.satuan));
            binding.tvHarga.setText(new StringBuilder("Rp " + formatter.format(Integer.parseInt(alatKesehatan.harga))));
            binding.tvStock.setText(new StringBuilder("Stock : " + alatKesehatan.jumlah));
        }
    }
}

