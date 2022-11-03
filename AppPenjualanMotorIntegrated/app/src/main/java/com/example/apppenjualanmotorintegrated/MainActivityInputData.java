package com.example.apppenjualanmotorintegrated;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;

import java.text.NumberFormat;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivityInputData extends Fragment {

    private EditText kodeMotor, namaMotor, satuanMotor, hargaMotor, stokMotor;
    private String setkodeMotor, setnamaMotor, setsatuanMotor, sethargaMotor, setstokMotor;
    private DatabaseHelper dbh;
    private Button openImage;
    ImageView imageView;
    Uri resultUri;

    public MainActivityInputData() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main_input_data, container, false);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        Button simpan = view.findViewById(R.id.inputButton);
        openImage = view.findViewById(R.id.pilihImage);
        imageView = view.findViewById(R.id.previewImage);
        kodeMotor = view.findViewById(R.id.kodeMotorET);
        namaMotor = view.findViewById(R.id.namaMotorET);
        satuanMotor = view.findViewById(R.id.satuanMotorET);
        hargaMotor = view.findViewById(R.id.hargaMotorET);
        stokMotor = view.findViewById(R.id.stokMotorET);

        //Inisialisasi dan Mendapatkan Konteks dari DatabaseHelper
        dbh = new DatabaseHelper(getActivity().getBaseContext());
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                if (setkodeMotor.equals("") || setnamaMotor.equals("") || setsatuanMotor.equals("") || sethargaMotor.equals("") || setsatuanMotor.equals("")){
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
        openImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CropImage.activity().setAspectRatio(4,4).getIntent(getContext());
                startActivityForResult(intent, CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });

        return view;
    }

    //Berisi Statement-Statement Untuk Mendapatkan Input Dari User
    private void setData(){
        setkodeMotor = kodeMotor.getText().toString();
        setnamaMotor = namaMotor.getText().toString();
        setsatuanMotor = satuanMotor.getText().toString();
        sethargaMotor = hargaMotor.getText().toString();
        setstokMotor = stokMotor.getText().toString();
    }

    //Berisi Statement-Statement Untuk Menyimpan Data Pada Database
    private void saveData() {
        //Mendapatkan Repository dengan Mode Menulis
        SQLiteDatabase create = dbh.getWritableDatabase();

        //Membuat Map Baru, Yang Berisi Judul Kolom dan Data Yang Ingin Dimasukan
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.MyColumns.KodeMotor, setkodeMotor);
        values.put(DatabaseHelper.MyColumns.NamaMotor, setnamaMotor);
        values.put(DatabaseHelper.MyColumns.SatuanMotor, setsatuanMotor);
        values.put(DatabaseHelper.MyColumns.HargaMotor, sethargaMotor);
        values.put(DatabaseHelper.MyColumns.StokMotor, setstokMotor);
        values.put(DatabaseHelper.MyColumns.GambarMotor,String.valueOf(resultUri));

        create.insert(DatabaseHelper.MyColumns.NamaTabel, null, values);
    }

    private void clearData(){
        kodeMotor.setText("");
        namaMotor.setText("");
        satuanMotor.setText("");
        hargaMotor.setText("");
        stokMotor.setText("");
        imageView.setImageResource(R.drawable.ic_image);
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