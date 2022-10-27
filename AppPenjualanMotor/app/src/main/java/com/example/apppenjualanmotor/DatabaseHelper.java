package com.example.apppenjualanmotor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String nama_db = "DB_JUAL1";
    public final static String nama_table = "Penjualan";

    public DatabaseHelper(Context context) {
        super(context, nama_db, null, 2);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE Penjualan (foto int, nama text, kode text primary key, satuan text, harga int, stok int, terjual text, sisa int)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Penjualan");
        onCreate(sqLiteDatabase);
    }

    public void tambahdata(String harga, String nama, String satuan, String kode, int gambar, Integer stok, String terjual, Integer sisa) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("foto",gambar);
        contentValues.put("nama",nama);
        contentValues.put("kode",kode);
        contentValues.put("satuan",satuan);
        contentValues.put("harga",harga);
        contentValues.put("stok",stok);
        contentValues.put("terjual",terjual);
        contentValues.put("sisa",sisa);
        db.insert(nama_table,null, contentValues);
    }

    public void updatedata(String harga, String nama, String satuan, String kode, int gambar, Integer stok, String terjual, Integer sisa) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("foto",gambar);
        contentValues.put("nama",nama);
        contentValues.put("kode",kode);
        contentValues.put("satuan",satuan);
        contentValues.put("harga",harga);
        contentValues.put("stok",stok);
        contentValues.put("terjual",terjual);
        contentValues.put("sisa",sisa);
        db.update(  nama_table, contentValues,"kode=?",new String[]{kode});
    }

    public Cursor bacadata() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("Select * from "+ nama_table, null);
        return res;
    }
}