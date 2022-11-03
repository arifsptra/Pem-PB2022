package com.example.appperpustakaan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdateActivity extends AppCompatActivity {
    private DbBook MyDatabase;
    private EditText NewKode, NewJudul, NewPembaca, NewRating, NewPenerbit, NewDeskripsi, NewHarga;
    private CircleImageView NewImage;
    private String getNewKode;
    private Button Update, Open;
    private String KodeSend = "KODE";
    private ImageView Back;
    Uri resultUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        MyDatabase = new DbBook(getBaseContext());

        NewKode = findViewById(R.id.NewformKode);
        NewJudul = findViewById(R.id.NewformJudul);
        NewPembaca = findViewById(R.id.NewformPembaca);
        NewRating = findViewById(R.id.NewformRating);
        NewPenerbit = findViewById(R.id.NewformPenerbit);
        NewHarga = findViewById(R.id.NewformHarga);
        NewDeskripsi = findViewById(R.id.NewformDeskripsi);
        NewImage = findViewById(R.id.Newimage_profile);

        Back = findViewById(R.id.back);

        Bundle extras = getIntent().getExtras();
        getNewKode = extras.getString(KodeSend);
        Update = findViewById(R.id.btnUpdate);
        Open = findViewById(R.id.NewbtnOpen);

        SQLiteDatabase ReadDb = MyDatabase.getReadableDatabase();
        Cursor cursor = ReadDb.rawQuery("SELECT * FROM " + DbBook.MyColumns.NamaTabel + " WHERE " + DbBook.MyColumns.KodeBuku + "=" + getNewKode, null);

        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String Kode = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.KodeBuku));
            @SuppressLint("Range") String Judul = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Judul));
            @SuppressLint("Range") String Pembaca = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Pembaca));
            @SuppressLint("Range") String Rating = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Rating));
            @SuppressLint("Range") String Penerbit = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Penerbit));
            @SuppressLint("Range") String Deskripsi = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Deskripsi));
            @SuppressLint("Range") String Harga = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Harga));
            @SuppressLint("Range") String Foto = cursor.getString(cursor.getColumnIndex(DbBook.MyColumns.Foto));


            NewKode.setText(Kode);
            NewJudul.setText(Judul);
            NewPembaca.setText(Pembaca);
            NewRating.setText(Rating);
            NewPenerbit.setText(Penerbit);
            NewDeskripsi.setText(Deskripsi);
            NewHarga.setText(Harga);
            NewImage.setImageURI(Uri.parse(Foto));

            Update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setUpdateData();
                    startActivity(new Intent(UpdateActivity.this, MainActivity.class));

                }
            });
            Back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                finish();
                }
            });
            Open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CropImage.startPickImageActivity(UpdateActivity.this);
                }
            });
        }
    }

    private void setUpdateData() {
        SQLiteDatabase ReadData = MyDatabase.getReadableDatabase();

            String getKode = NewKode.getText().toString().trim();
            String getJudul = NewJudul.getText().toString().trim();
            String getPembaca = NewPembaca.getText().toString().trim();
            String getRating = NewRating.getText().toString().trim();
            String getPenerbit = NewPenerbit.getText().toString().trim();
            String getDeskripsi = NewDeskripsi.getText().toString().trim();
            String getHarga = NewHarga.getText().toString().trim();


            //Memasukan Data baru pada
            ContentValues values = new ContentValues();
            values.put(DbBook.MyColumns.KodeBuku, getKode);
            values.put(DbBook.MyColumns.Judul, getJudul);
            values.put(DbBook.MyColumns.Pembaca, getPembaca);
            values.put(DbBook.MyColumns.Rating, getRating);
            values.put(DbBook.MyColumns.Penerbit, getPenerbit);
            values.put(DbBook.MyColumns.Deskripsi, getDeskripsi);
            values.put(DbBook.MyColumns.Harga, getHarga);
            values.put(DbBook.MyColumns.Foto, String.valueOf(resultUri));

            //Untuk Menentukan Data/Item yang ingin diubah, berdasarkan NIM
            String selection = DbBook.MyColumns.KodeBuku + " LIKE ?";
            String[] selectionArgs = {getNewKode};
            ReadData.update(DbBook.MyColumns.NamaTabel, values, selection, selectionArgs);
            Toast.makeText(getApplicationContext(), "Berhasil Diubah", Toast.LENGTH_SHORT).show();
        }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE
                && resultCode == Activity.RESULT_OK) {
            Uri imageuri = CropImage.getPickImageResultUri(this, data);
            if (CropImage.isReadExternalStoragePermissionsRequired(this, imageuri)) {
                resultUri = imageuri;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}
                        , 0);
            } else {
                startCrop(imageuri);
            }
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                NewImage.setImageURI(result.getUri());
                resultUri = result.getUri();
            }
        }
    }

    private void startCrop(Uri imageuri) {
        CropImage.activity(imageuri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(3, 4)
                .start(this);
        resultUri = imageuri;
    }
}