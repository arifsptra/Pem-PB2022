package com.example.appperpustakaan;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.theartofdev.edmodo.cropper.CropImage;

import java.text.NumberFormat;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


public class TambahFragment extends Fragment {

    private EditText KodeBuku, Judul, Pembaca, Rating, Penerbit, Deskripsi, Harga;
    private String setKodeBuku, setJudul, setPembaca, setRating, setPenerbit, setDeskripsi, setHarga;
    private DbBook dbBook;
    private Button Open;
    CircleImageView imageView;
    Uri resultUri;

    public TambahFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tambah, container, false);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        Button simpan       = view.findViewById(R.id.btnSubmit);
        Open                = view.findViewById(R.id.btnOpen);
        imageView           = (CircleImageView) view.findViewById(R.id.image_profile);
        KodeBuku            = view.findViewById(R.id.formKode);
        Judul               = view.findViewById(R.id.formJudul);
        Pembaca             = view.findViewById(R.id.formPembaca);
        Rating              = view.findViewById(R.id.formRating);
        Harga               = view.findViewById(R.id.formHarga);
        Deskripsi           = view.findViewById(R.id.formDeskripsi);
        Penerbit            = view.findViewById(R.id.formPenerbit);

        //Inisialisasi dan Mendapatkan Konteks dari DbBook
        dbBook = new DbBook(getActivity().getBaseContext());
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                if (setKodeBuku.equals("") || setJudul.equals("") || setPembaca.equals("") || setRating.equals("") || setPenerbit.equals("") || setDeskripsi.equals("") || setHarga.equals("")){
                    Toast.makeText(getActivity().getApplicationContext(),"Data Buku Belum Lengkap atau Belum diisi, Lengkapi Dahulu!", Toast.LENGTH_SHORT).show();
                }else {
                    setData();
                    saveData();
                    Toast.makeText(getActivity().getApplicationContext(),"Data Buku Tersimpan", Toast.LENGTH_SHORT).show();
                    clearData();
                }
                }
        });
        //intent eksternal untuk masuk kedalam folder atau galeri
        Open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CropImage.activity().setAspectRatio(3,4).getIntent(getContext());
                startActivityForResult(intent, CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });

        return view;
    }

    //Berisi Statement-Statement Untuk Mendapatkan Input Dari User
    private void setData(){
        setKodeBuku = KodeBuku.getText().toString();
        setJudul = Judul.getText().toString();
        setPembaca = Pembaca.getText().toString();
        setRating = Rating.getText().toString();
        setPenerbit = Penerbit.getText().toString();
        setDeskripsi = Deskripsi.getText().toString();
        setHarga = Harga.getText().toString();
    }

    //Berisi Statement-Statement Untuk Menyimpan Data Pada Database
    private void saveData() {
        //Mendapatkan Repository dengan Mode Menulis
        SQLiteDatabase create = dbBook.getWritableDatabase();

        //Membuat Map Baru, Yang Berisi Judul Kolom dan Data Yang Ingin Dimasukan
        ContentValues values = new ContentValues();
        values.put(DbBook.MyColumns.KodeBuku, setKodeBuku);
        values.put(DbBook.MyColumns.Judul, setJudul);
        values.put(DbBook.MyColumns.Pembaca, setPembaca);
        values.put(DbBook.MyColumns.Rating, setRating);
        values.put(DbBook.MyColumns.Penerbit, setPenerbit);
        values.put(DbBook.MyColumns.Deskripsi, setDeskripsi);
        values.put(DbBook.MyColumns.Harga, setHarga);
        values.put(DbBook.MyColumns.Foto,String.valueOf(resultUri));

        create.insert(DbBook.MyColumns.NamaTabel, null, values);
        }

    private void clearData(){
        KodeBuku.setText("");
        Judul.setText("");
        Pembaca.setText("");
        Rating.setText("");
        Penerbit.setText("");
        Deskripsi.setText("");
        Harga.setText("");
        imageView.setImageResource(R.drawable.ic_picimg);
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode ==  Activity.RESULT_OK) {
                resultUri = result.getUri();
                Log.e("resultUri ->", String.valueOf(resultUri));
                imageView.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Log.e("error ->", String.valueOf(error));
            }
        }
    }



}
