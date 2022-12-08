package com.example.projekunggulan.CLASS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projekunggulan.API.IterfacesMatakuliah;
import com.example.projekunggulan.Model.MakuliahModel;
import com.example.projekunggulan.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.InterfaceAddress;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryDataMatakuliah extends AppCompatActivity {

    EditText enip, enama, ejenis, estatus, ependidikan, ealamat, ekota;
    Button bsave, bview;
    ArrayList<MakuliahModel> dataArrayList=new ArrayList<>();
    IterfacesMatakuliah iterfacesMatakuliah;

    DatabaseReference dbf;
    MakuliahModel mkm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_matakuliah);

        enip = findViewById(R.id.edit_nip);
        enama = findViewById(R.id.edit_nama);
        ejenis = findViewById(R.id.edit_jk);
        estatus = findViewById(R.id.edit_status);
        ependidikan = findViewById(R.id.edit_pendidikan);
        ealamat = findViewById(R.id.edit_alamat);
        ekota = findViewById(R.id.edit_kota);

        bsave = findViewById(R.id.button_save);
        bview = findViewById(R.id.button_view);

        dbf = FirebaseDatabase.getInstance().getReference().child("Matakuliah");

        mkm = new MakuliahModel();

        bsave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mkm.setNip(enip.getText().toString());
                mkm.setNama_pegawai(enama.getText().toString());
                mkm.setJenis_kel(ejenis.getText().toString());
                mkm.setStatus(estatus.getText().toString());
                mkm.setPendidikan(ependidikan.getText().toString());
                mkm.setAlamat(ealamat.getText().toString());
                mkm.setKota(ekota.getText().toString());
                Toast.makeText(EntryDataMatakuliah.this, "Save Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }


//    @Override
//    public void onClick(View v) {
//        mkm = new MakuliahModel();
//        if(v.getId()==R.id.button_save){
//            //
//            iterfacesMatakuliah=KoneksiMatakuliah.Koneksi().create(IterfacesMatakuliah.class);
//            String xnip = enip.getText().toString();
//            String xnama = enama.getText().toString();
//            String xjenis = ejenis.getText().toString();
//            String xstatus = estatus.getText().toString();
//            String xpendidikan = ependidikan.getText().toString();
//            String xalamat = ealamat.getText().toString();
//            String xkota = ekota.getText().toString();
//
//            Call<MakuliahModel> saveData = iterfacesMatakuliah.simpanData(xnip, xnama, xjenis, xstatus, xpendidikan, xalamat, xkota);
//            saveData.enqueue(new Callback<MakuliahModel>() {
//                @Override
//                public void onResponse(Call<MakuliahModel> call, Response<MakuliahModel> response) {
//                    mkm.setNip(xnip);
//                    mkm.setNama_pegawai(xnama);
//                    mkm.setJenis_kel(xjenis);
//                    mkm.setStatus(xstatus);
//                    mkm.setPendidikan(xpendidikan);
//                    mkm.setAlamat(xalamat);
//                    mkm.setKota(xkota);
//                    Toast.makeText(EntryDataMatakuliah.this, "Save Success!", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onFailure(Call<MakuliahModel> call, Throwable t) {
//                    Toast.makeText(EntryDataMatakuliah.this, "Save Failed!", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }else{
//            //
//        }
//    }
}