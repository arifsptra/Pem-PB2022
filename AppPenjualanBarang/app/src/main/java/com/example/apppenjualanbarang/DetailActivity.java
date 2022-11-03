package com.example.apppenjualanbarang;

import static com.example.apppenjualanbarang.Constants.EXTRA_ALATKESEHATAN;
import static com.example.apppenjualanbarang.Constants.EXTRA_POSITION;
import static com.example.apppenjualanbarang.Constants.EXTRA_QUANTITY;
import static com.example.apppenjualanbarang.Constants.RESULT_DELETE;
import static com.example.apppenjualanbarang.Constants.RESULT_UPDATE;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.GAMBAR;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.HARGA;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.JUMLAH;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.KODE;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.NAMA;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.SATUAN;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.STOK;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.TERJUAL;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apppenjualanbarang.databinding.ActivityDetailBinding;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    private AlatKesehatan alatKesehatan;
    private int position;
    private AlatKesehatanHelper alatKesehatanHelper;
    private int qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        alatKesehatanHelper = AlatKesehatanHelper.getInstance(getApplicationContext());
        alatKesehatanHelper.open();

        alatKesehatan = getIntent().getParcelableExtra(EXTRA_ALATKESEHATAN);
        position = getIntent().getIntExtra(EXTRA_POSITION, 0);

        DecimalFormat formatter = new DecimalFormat("#,###,###");

        if (Integer.parseInt(alatKesehatan.jumlah) > 0) {
            qty = 1;
            binding.plusBtn.setEnabled(true);
            binding.removeBtn.setEnabled(true);
            binding.btnBuy.setEnabled(true);
        } else {
            qty = 0;
            binding.plusBtn.setEnabled(false);
            binding.removeBtn.setEnabled(false);
            binding.btnBuy.setEnabled(false);
        }

        Bitmap bitmap = BitmapFactory.decodeByteArray(Base64.decode(alatKesehatan.gambar, Base64.DEFAULT), 0, Base64.decode(alatKesehatan.gambar, Base64.DEFAULT).length);
        binding.ivAlatKesehatan.setImageBitmap(bitmap);
        binding.tvAlatKesehatanName.setText(alatKesehatan.nama);
        binding.tvKode.setText(alatKesehatan.kode);
        binding.tvHarga.setText(new StringBuilder("Rp " + formatter.format(Integer.parseInt(alatKesehatan.harga))));
        binding.tvSatuan.setText(new StringBuilder(" / 1 " + alatKesehatan.satuan));
        binding.tvStock.setText(new StringBuilder("Stock : " + alatKesehatan.jumlah));
        binding.tvQty.setText(String.valueOf(qty));

        binding.plusBtn.setOnClickListener(v -> {
            qty++;
            if (qty > Integer.parseInt(alatKesehatan.jumlah)) {
                qty = Integer.parseInt(alatKesehatan.jumlah);
            }
            binding.tvQty.setText(String.valueOf(qty));
        });

        binding.removeBtn.setOnClickListener(v -> {
            qty--;
            if (qty < 1) {
                qty = 1;
            }
            binding.tvQty.setText(String.valueOf(qty));
        });

        binding.btnBuy.setOnClickListener(v -> {
            Intent intent = new Intent();

            AlatKesehatan alatKesehatanUpdate = new AlatKesehatan();
            alatKesehatanUpdate.id = alatKesehatan.id;
            alatKesehatanUpdate.gambar = alatKesehatan.gambar;
            alatKesehatanUpdate.kode = alatKesehatan.kode;
            alatKesehatanUpdate.nama = alatKesehatan.nama;
            alatKesehatanUpdate.satuan = alatKesehatan.satuan;
            alatKesehatanUpdate.harga = alatKesehatan.harga;
            alatKesehatanUpdate.jumlah = String.valueOf((Integer.parseInt(alatKesehatan.jumlah) - qty));

            intent.putParcelableArrayListExtra(EXTRA_ALATKESEHATAN, alatKesehatanUpdate);
            intent.putExtra(EXTRA_POSITION, position);

            ContentValues values = new ContentValues();
            values.put(KODE, alatKesehatan.kode);
            values.put(NAMA, alatKesehatan.nama);
            values.put(SATUAN, alatKesehatan.satuan);
            values.put(HARGA, alatKesehatan.harga);
            values.put(JUMLAH, String.valueOf((Integer.parseInt(alatKesehatan.jumlah) - qty)));
            values.put(GAMBAR, alatKesehatan.gambar);
            values.put(STOK, alatKesehatan.jumlah);
            values.put(TERJUAL, qty);

            long result = alatKesehatanHelper.update(String.valueOf(alatKesehatan.id), values);
            Toast.makeText(this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            if (result > 0) {
                setResult(RESULT_UPDATE, intent);
                Intent iOrder = new Intent(DetailActivity.this, OrderActivity.class);
                iOrder.putParcelableArrayListExtra(EXTRA_ALATKESEHATAN, alatKesehatanUpdate);
                iOrder.putExtra(EXTRA_QUANTITY, qty);
                startActivity(iOrder);
                finish();
            } else {
                Toast.makeText(this, "Gagal membeli!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showAlertDialog() {
        String dialogTitle, dialogMessage;
        dialogTitle = "Hapus";
        dialogMessage = "Apakah anda ingin menghapus item ini?";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(dialogTitle);
        alertDialogBuilder
                .setMessage(dialogMessage)
                .setCancelable(false)
                .setPositiveButton("Ya", (dialog, id) -> {
                    long result = alatKesehatanHelper.deleteById(String.valueOf(alatKesehatan.id));
                    if (result > 0) {
                        Intent intent = new Intent();
                        intent.putExtra(EXTRA_POSITION, position);
                        setResult(RESULT_DELETE, intent);
                        finish();
                    } else {
                        Toast.makeText(DetailActivity.this, "Gagal menghapus data", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Tidak", (dialog, id) -> dialog.cancel());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_delete_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_item) {
            showAlertDialog();
        }
        return super.onOptionsItemSelected(item);
    }
}