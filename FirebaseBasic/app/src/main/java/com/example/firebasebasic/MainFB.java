package com.example.firebasebasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainFB extends AppCompatActivity {
    RecyclerView recyclerView_mtkul;
    DatabaseReference dbr;
    ArrayList<MakuliahModel> modelDataMatakulArrayList=new ArrayList<>();
    FloatingActionButton binput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fb);
        recyclerView_mtkul=findViewById(R.id.rv_matakuliah);
        dbr= FirebaseDatabase.getInstance().getReference();
        binput = findViewById(R.id.floatbutton);
        tampilkan_matakuliah();
        recyclerView_mtkul.setLayoutManager(new LinearLayoutManager(this));
        binput.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainFB.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void tampilkan_matakuliah() {
        dbr.child("Akademik").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    MakuliahModel modelDataMatakul=dataSnapshot.getValue(MakuliahModel.class);
                    modelDataMatakulArrayList.add(modelDataMatakul);
                }

                AdapterMatakuliah adapterMatakuliah=new AdapterMatakuliah(MainFB.this,modelDataMatakulArrayList);
                recyclerView_mtkul.setAdapter(adapterMatakuliah);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}