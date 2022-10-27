package com.example.belajarsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String nama_db = "db_app_motor";
    public final static String nama_tabel = "honda_motor";

    public final static String field_01 = "kodeMotor";
    public final static String field_02 = "namaMotor";

    public DatabaseHelper(Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+nama_tabel+"(kodeMotor text primary key, namaMotor text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
        db.execSQL("DROP TABLE IF EXIST"+nama_tabel);
        onCreate(db);
    }

    public void tambahData(String kodeMotor, String namaMotor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(field_01,kodeMotor);
        contentValues.put(field_02,namaMotor);
        db.insert(nama_tabel, null, contentValues);
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+nama_tabel, null);
        return res;
    }

    public void update_data(String kode_motor, String nama_motor) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(field_01, kode_motor);
        contentValues.put(field_02, nama_motor);

        db.update(nama_tabel, contentValues, "kodeMotor=?", new String[] {kode_motor});
    }
}
