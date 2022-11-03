package com.example.apppenjualanbarang;

import static com.example.apppenjualanbarang.Constants.EXTRA_ALATKESEHATAN;
import static com.example.apppenjualanbarang.Constants.EXTRA_QUANTITY;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apppenjualanbarang.databinding.ActivityOrderBinding;

import java.text.DecimalFormat;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    AlatKesehatan alatKesehatan;
    int ppn;
    int qty, harga, bayar, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DecimalFormat formatter = new DecimalFormat("#,###,###");

        alatKesehatan = getIntent().getParcelableExtra(EXTRA_ALATKESEHATAN);
        qty = getIntent().getIntExtra(EXTRA_QUANTITY, 0);
        harga = Integer.parseInt(alatKesehatan.harga);
        total = qty * harga;
        ppn = (int) (total * 0.11);
        bayar = total + ppn;

        binding.tvAlatKesehatanName.setText(alatKesehatan.nama);
        binding.tvHarga.setText(new StringBuilder("Rp " + formatter.format(harga)));
        binding.tvQuantity.setText(new StringBuilder(qty + " " + alatKesehatan.satuan));
        binding.tvTotal.setText(new StringBuilder("Rp " + formatter.format(total)));
        binding.tvPpn.setText(new StringBuilder("Rp " + formatter.format(ppn)));
        binding.tvBayar.setText(new StringBuilder("Rp " + formatter.format(bayar)));
    }
}