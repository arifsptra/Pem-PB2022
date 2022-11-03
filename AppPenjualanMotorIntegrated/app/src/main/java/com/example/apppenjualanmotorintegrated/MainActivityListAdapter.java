package com.example.apppenjualanmotorintegrated;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivityListAdapter extends RecyclerView.Adapter<MainActivityListAdapter.ViewHolder>{
    private ArrayList kodeMotor;
    private ArrayList namaMotor;
    private ArrayList satuanMotor;
    private ArrayList hargaMotor;
    private ArrayList stokMotor;
    private ArrayList gambarMotor;
    private Context context;
    RecyclerView mRecyclerView;


    //Membuat Konstruktor pada Class RecyclerViewAdapter
     MainActivityListAdapter(MainActivityList listFragment, ArrayList kodeMotorList, ArrayList namaMotorList, ArrayList satuanMotorList, ArrayList hargaMotorList, ArrayList stokMotorList, ArrayList gambarMotorList) {
         this.kodeMotor = kodeMotorList;
         this.namaMotor = namaMotorList;
         this.satuanMotor = satuanMotorList;
         this.hargaMotor = hargaMotorList;
         this.stokMotor = stokMotorList;
         this.gambarMotor = gambarMotorList;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView kode, nama, satuan, harga, stok;
        private ImageView gambar;
        private Button detail;


        ViewHolder(View itemView) {
            super(itemView);

            //Mendapatkan Context dari itemView yang terhubung dengan Activity ViewData
            context = itemView.getContext();

            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            mRecyclerView = itemView.findViewById(R.id.recycler);
            kode = itemView.findViewById(R.id.kodeMotorText);
            nama = itemView.findViewById(R.id.namaMotorText);
            satuan = itemView.findViewById(R.id.satuanMotorText);
            harga = itemView.findViewById(R.id.hargaMotorText);
            stok = itemView.findViewById(R.id.stokMotorText);
            gambar = itemView.findViewById(R.id.gambarMotorImage);
            detail = itemView.findViewById(R.id.gotodetail);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_list_view, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat pada Posisi Tertentu
        final String kode = (String) kodeMotor.get(position);
        final String nama = (String) namaMotor.get(position);
        final String satuan = (String) satuanMotor.get(position);
        final Double harga = (Double) hargaMotor.get(position);
        final String stok = (String) stokMotor.get(position);
        final String gambar = (String) gambarMotor.get(position);
        holder.kode.setText(kode);
        holder.nama.setText(nama);
        holder.satuan.setText(satuan);
        holder.harga.setText(formatRupiah.format((double) harga));
        holder.stok.setText(stok);
        holder.gambar.setImageURI(Uri.parse(gambar));

//      Panggil Onclik Hapus untuk Hapus db dan juga recyclveiw didalam showdialog
//        holder.Delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View view) {
//                showDialog();
//            }
//
//            //          dialog hapus
//            private void showDialog(){
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//
//                // set title dialog
//                alertDialogBuilder.setTitle("Apakah Anda Ingin Menghapus Data ini?");
//
//                // set pesan dari dialog
//                alertDialogBuilder
//                        .setIcon(R.drawable.ic_delete)
//                        .setCancelable(false)
//                        .setPositiveButton("Hapus",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog,int id) {
//                                // jika tombol diklik, maka akan menutup activity ini
//
//                                //Menghapus Data Dari Database
//                                DbBook getDatabase = new DbBook(context);
//                                SQLiteDatabase DeleteData = getDatabase.getWritableDatabase();
//                                //Menentukan di mana bagian kueri yang akan dipilih
//                                String selection = DbBook.MyColumns.KodeBuku + " LIKE ?";
//                                //Menentukan Judul Dari Data Yang Ingin Dihapus
//                                String[] selectionArgs = {holder.Kode.getText().toString()};
//                                DeleteData.delete(DbBook.MyColumns.NamaTabel, selection, selectionArgs);
//
//                                //Menghapus Data pada List dari Posisi Tertentu
//                                int position = kodeList.indexOf(Kode);
//                                kodeList.remove(position);
//                                notifyItemRemoved(position);
//                                Toast.makeText(context,"Data Dihapus",Toast.LENGTH_SHORT).show();
//
//                            }
//                        })
//                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                // jika tombol ini diklik, akan menutup dialog
//                                // dan tidak terjadi apa2
//                                dialog.cancel();
//                            }
//                        });
//
//                // membuat alert dialog dari builder
//                AlertDialog alertDialog = alertDialogBuilder.create();
//
//                // menampilkan alert dialog
//                alertDialog.show();
//            }
//
//
//        });

//        onklik see detail
    }

    @Override
    public int getItemCount() {
        return kodeMotor.size();
    }
}