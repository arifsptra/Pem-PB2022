package com.example.apppenjualanbarang;

import static com.example.apppenjualanbarang.Constants.EXTRA_ALATKESEHATAN;
import static com.example.apppenjualanbarang.Constants.RESULT_ADD;
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
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apppenjualanbarang.databinding.ActivityAddBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddActivity extends AppCompatActivity {
    ActivityAddBinding binding;

    AlatKesehatanHelper alatKesehatanHelper;
    int quantity;
    String image;

    private final ActivityResultLauncher<Intent> pickImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        Uri imageUri = result.getData().getData();
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.ivAlatKesehatanProfile.setImageBitmap(bitmap);
                            image = encodeImage(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        alatKesehatanHelper = AlatKesehatanHelper.getInstance(getApplicationContext());
        alatKesehatanHelper.open();

        String[] satuan = getResources().getStringArray(R.array.satuan);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_item, satuan);
        binding.etSatuanAlatKesehatan.setAdapter(arrayAdapter);

        setListeners();
    }

    private void setListeners() {
        quantity = 1;

        binding.btnChangeImage.setOnClickListener(v -> {
            Intent iPickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            iPickImage.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            pickImage.launch(iPickImage);
        });

        binding.plusBtn.setOnClickListener(v -> {
            quantity++;
            binding.tvQty.setText(String.valueOf(quantity));
        });

        binding.removeBtn.setOnClickListener(v -> {
            quantity--;
            if (quantity < 1) {
                quantity = 1;
            }
            binding.tvQty.setText(String.valueOf(quantity));
        });

        binding.btnAddAlatKesehatan.setOnClickListener(v -> {
            if (isValidAddDetails()) {
                String image = this.image;
                String kode = binding.etKodeAlatKesehatan.getText().toString();
                String nama = binding.etNamaAlatKesehatan.getText().toString();
                String satuan = binding.etSatuanAlatKesehatan.getText().toString();
                String harga = binding.etHargaAlatKesehatan.getText().toString();
                String jumlah = String.valueOf(quantity);
                String stok = String.valueOf(quantity);
                String terjual = "0";

                AlatKesehatan alatKesehatan = new AlatKesehatan();
                alatKesehatan.gambar = image;
                alatKesehatan.kode = kode;
                alatKesehatan.nama = nama;
                alatKesehatan.satuan = satuan;
                alatKesehatan.harga = harga;
                alatKesehatan.jumlah = jumlah;
                alatKesehatan.stok = stok;
                alatKesehatan.terjual = terjual;

                Intent intent = new Intent();
                intent.putParcelableArrayListExtra(EXTRA_ALATKESEHATAN, alatKesehatan);

                ContentValues values = new ContentValues();
                values.put(KODE, kode);
                values.put(NAMA, nama);
                values.put(SATUAN, satuan);
                values.put(HARGA, harga);
                values.put(JUMLAH, jumlah);
                values.put(GAMBAR, image);
                values.put(STOK, stok);
                values.put(TERJUAL, terjual);

                long result = alatKesehatanHelper.insert(values);

                if (result > 0) {
                    alatKesehatan.id = (int) result;
                    setResult(RESULT_ADD, intent);
                    finish();
                } else {
                    showToast("Gagal menambahkan data!");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    private boolean isValidAddDetails() {
        if (image == null) {
            showToast("Tambahkan gambar terlebih dahulu!");
            return false;
        } else if (binding.etKodeAlatKesehatan.getText().toString().trim().isEmpty()) {
            showToast("Masukkan kode alat kesehatan terlebih dahulu!");
            return false;
        } else if (binding.etNamaAlatKesehatan.getText().toString().trim().isEmpty()) {
            showToast("Masukkan nama alat kesehatan terlebih dahulu!");
            return false;
        } else if (!binding.etHargaAlatKesehatan.getText().toString().matches(".*\\d.*")) {
            showToast("Masukkan harga dengan benar!");
            return false;
        } else {
            return true;
        }
    }

    public String encodeImage(Bitmap bitmap) {
        int previewWidth = 200;
        int previewHeight = bitmap.getHeight() * previewWidth / bitmap.getWidth();
        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth, previewHeight, false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showAlertDialog() {
        String dialogTitle, dialogMessage;
        dialogTitle = "Batal";
        dialogMessage = "Apakah anda ingin membatalkan penambahan data?";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(dialogTitle);
        alertDialogBuilder
                .setMessage(dialogMessage)
                .setCancelable(false)
                .setPositiveButton("Ya", (dialog, id) -> {
                    finish();
                })
                .setNegativeButton("Tidak", (dialog, id) -> dialog.cancel());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}