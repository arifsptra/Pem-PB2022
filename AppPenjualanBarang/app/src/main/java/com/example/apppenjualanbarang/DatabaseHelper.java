package com.example.apppenjualanbarang;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db_alatkesehatan_app";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_ALATKESEHATAN = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_NAME,
            DatabaseContract.AlatKesehatanColumns._ID,
            DatabaseContract.AlatKesehatanColumns.KODE,
            DatabaseContract.AlatKesehatanColumns.NAMA,
            DatabaseContract.AlatKesehatanColumns.SATUAN,
            DatabaseContract.AlatKesehatanColumns.HARGA,
            DatabaseContract.AlatKesehatanColumns.JUMLAH,
            DatabaseContract.AlatKesehatanColumns.GAMBAR,
            DatabaseContract.AlatKesehatanColumns.STOK,
            DatabaseContract.AlatKesehatanColumns.TERJUAL
    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_ALATKESEHATAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<ModelLaporan> getalldata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from alatkesehatan", null,null);
        ArrayList<ModelLaporan> arr = new ArrayList<>();
        while(cursor.moveToNext()){
            ModelLaporan not = new ModelLaporan();
            not.kode = cursor.getString(1);
            not.gambar = cursor.getString(6);
            not.nama = cursor.getString(2);
            not.satuan = cursor.getString(3);
            not.stok = cursor.getString(7);
            not.harga = cursor.getString(4);
            not.terjual = cursor.getString(8);
            not.sisa = cursor.getString(5);
            arr.add(not);
        }
        return arr;
    }
}