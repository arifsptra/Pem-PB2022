package com.example.a03basicappdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String NAMA_DATABASE = "AKADEMIK";

    public final static String NAMA_TABEL = "MATAKULIAH";
    public final static String NAMA_TABEL2 = "MAHASISWA";
    public final static String NAMA_TABEL3 = "KHS";

    public final static String field01 = "kode";
    public final static String field02 = "nama_mtkl";
    public final static String field03 = "sks";
    public final static String field04 = "syarat";

    public DatabaseHelper(Context context) {
        super(context, NAMA_DATABASE, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+NAMA_TABEL+"(kode text primary key,"+"nama_mtkl text,"+"sks text,"+"syarat text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+NAMA_TABEL);
        onCreate(db);
    }

    public boolean input_matakuliah(String xkode, String xnama, String xsks, String xsyarat) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(field01, xkode);
        contentValues.put(field02, xnama);
        contentValues.put(field03, xsks);
        contentValues.put(field04, xsyarat);

        long hasil = db.insert(NAMA_TABEL, null, contentValues);

        if(hasil>0){
            return true;
        }

        return false;
    }

    public Cursor baca_matakuliah() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("select * from "+NAMA_TABEL, null);
        return cur;
    }
}
