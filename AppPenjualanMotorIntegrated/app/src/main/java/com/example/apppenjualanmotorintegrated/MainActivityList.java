package com.example.apppenjualanmotorintegrated;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityList extends Fragment {

    private DatabaseHelper MyDatabase;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    private ArrayList kodeMotor;
    private ArrayList namaMotor;
    private ArrayList satuanMotor;
    private ArrayList hargaMotor;
    private ArrayList stokMotor;
    private ArrayList gambarMotor;

    public MainActivityList() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main_list, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                kodeMotor = new ArrayList<>();
                namaMotor = new ArrayList<>();
                satuanMotor = new ArrayList<>();
                hargaMotor = new ArrayList<>();
                stokMotor = new ArrayList<>();
                gambarMotor = new ArrayList<>();

                MyDatabase = new DatabaseHelper(getActivity().getBaseContext());
                recyclerView = view.findViewById(R.id.recycler);
                getData();
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                adapter = new MainActivityListAdapter(MainActivityList.this, kodeMotor, namaMotor, satuanMotor, hargaMotor, stokMotor, gambarMotor);
                //Memasang Adapter pada RecyclerView
                recyclerView.setAdapter(adapter);
                //Membuat Underline pada Setiap Item Didalam List
//                DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL);
//                itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.line));
//                recyclerView.addItemDecoration(itemDecoration);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        kodeMotor   = new ArrayList<>();
        namaMotor = new ArrayList<>();
        satuanMotor = new ArrayList<>();
        hargaMotor = new ArrayList<>();
        stokMotor = new ArrayList<>();
        gambarMotor = new ArrayList<>();

        MyDatabase = new DatabaseHelper(getActivity().getBaseContext());
        recyclerView = view.findViewById(R.id.recycler);
        getData();
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new MainActivityListAdapter(MainActivityList.this, kodeMotor, namaMotor, satuanMotor, hargaMotor, stokMotor, gambarMotor);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
        //Membuat Underline pada Setiap Item Didalam List
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL);
//        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.));
//        recyclerView.addItemDecoration(itemDecoration);

        return view;
    }

    //Berisi Statement-Statement Untuk Mengambi Data dari Database
    @SuppressLint("Recycle")
    protected void getData() {
        //Mengambil Repository dengan Mode Membaca
        SQLiteDatabase ReadData = MyDatabase.getReadableDatabase();
        Cursor cursor = ReadData.rawQuery("SELECT * FROM " + DatabaseHelper.MyColumns.NamaTabel, null);

        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal

        //Melooping Sesuai Dengan Jumlan Data (Count) pada cursor
        for (int count = 0; count < cursor.getCount(); count++) {

            cursor.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir

//            Mengambil data dari sesuai kolom array
            kodeMotor.add(cursor.getString(0));
            namaMotor.add(cursor.getString(1));
            satuanMotor.add(cursor.getString(2));
            hargaMotor.add(cursor.getDouble(3));
            stokMotor.add(cursor.getString(4));
            gambarMotor.add(cursor.getString(5));
        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
////        inflater=getMenuInflater();
//        inflater.inflate(R.menu.menus,menu);
//        return true;
//    }
//
//    @Override
//    public  boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()) {
//            case R.id.menu_list:
//                Toast.makeText(this, "Item list selected", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.menu_grid:
//                Toast.makeText(this, "Item grid selected", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivityList.this, MainActivity.class);
//                startActivity(intent);
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}