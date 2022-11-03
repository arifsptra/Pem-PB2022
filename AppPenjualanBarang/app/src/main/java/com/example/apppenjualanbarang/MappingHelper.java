package com.example.apppenjualanbarang;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {

    public static ArrayList<AlatKesehatan> mapCursorToArrayList(Cursor alatKesehatanCursor) {
        ArrayList<AlatKesehatan> alatKesehatanList = new ArrayList<>();

        while (alatKesehatanCursor.moveToNext()) {
            int id = alatKesehatanCursor.getInt(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns._ID));
            String kode = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.KODE));
            String nama = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.NAMA));
            String satuan = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.SATUAN));
            String harga = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.HARGA));
            String jumlah = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.JUMLAH));
            String gambar = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.GAMBAR));
            String stok = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.STOK));
            String terjual = alatKesehatanCursor.getString(alatKesehatanCursor.getColumnIndexOrThrow(DatabaseContract.AlatKesehatanColumns.TERJUAL));

            AlatKesehatan alatKesehatan = new AlatKesehatan();
            alatKesehatan.id = id;
            alatKesehatan.kode = kode;
            alatKesehatan.nama = nama;
            alatKesehatan.satuan = satuan;
            alatKesehatan.harga = harga;
            alatKesehatan.jumlah = jumlah;
            alatKesehatan.gambar = gambar;
            alatKesehatan.stok = stok;
            alatKesehatan.terjual = terjual;
            alatKesehatanList.add(alatKesehatan);
        }

        return alatKesehatanList;
    };
}
