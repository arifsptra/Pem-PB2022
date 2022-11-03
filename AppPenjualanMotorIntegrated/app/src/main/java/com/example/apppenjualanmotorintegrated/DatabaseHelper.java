package com.example.apppenjualanmotorintegrated;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase db;

    static abstract class MyColumns implements BaseColumns {
        static final String NamaTabel = "DataMotor";
        static final String KodeMotor = "KodeMotor";
        static final String NamaMotor = "NamaMotor";
        static final String SatuanMotor = "SatuanMotor";
        static final String HargaMotor = "HargaMotor";
        static final String StokMotor = "StokMotor";
        static final String GambarMotor = "GambarMotor";
    }

    private static final String NamaDatabse = "dbmotor.db";
    private static final int VersiDatabase = 1;

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + MyColumns.NamaTabel +
            "(" + MyColumns.KodeMotor + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + MyColumns.NamaMotor + " TEXT NOT NULL, "
            + MyColumns.SatuanMotor + " TEXT NOT NULL, "
            + MyColumns.HargaMotor + " TEXT NOT NULL, "
            + MyColumns.StokMotor + " TEXT NOT NULL, "
            + MyColumns.GambarMotor + " TEXT NOT NULL)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + MyColumns.NamaTabel;

    DatabaseHelper(Context context) {
        super(context, NamaDatabse, null, VersiDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ MyColumns.NamaTabel, null);
        return res;
    }

//    //Get 1 Data By ID
//    public static Cursor oneData(Long id) {
//        Cursor cur = db.rawQuery("SELECT * FROM " + MyColumns.NamaTabel + " WHERE " + MyColumns.KodeBuku + "=" + id, null);
//        return cur;
//    }


}

