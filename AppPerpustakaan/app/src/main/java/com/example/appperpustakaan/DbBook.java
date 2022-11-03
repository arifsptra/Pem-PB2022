package com.example.appperpustakaan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbBook extends SQLiteOpenHelper {
    private static SQLiteDatabase db;

    static abstract class MyColumns implements BaseColumns {
        static final String NamaTabel = "DataBuku";
        static final String KodeBuku = "KodeBuku";
        static final String Judul = "JudulBuku";
        static final String Pembaca = "Pembaca";
        static final String Rating = "Rating";
        static final String Penerbit = "Penerbit";
        static final String Deskripsi = "Deskripsi";
        static final String Harga = "HargaSatuan";
        static final String Foto = "GambarPic";
    }

    private static final String NamaDatabse = "dbmybook.db";
    private static final int VersiDatabase = 1;

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + MyColumns.NamaTabel +
            "(" + MyColumns.KodeBuku + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + MyColumns.Judul + " TEXT NOT NULL, "
            + MyColumns.Pembaca + " TEXT NOT NULL, "
            + MyColumns.Rating + " TEXT NOT NULL, "
            + MyColumns.Penerbit + " TEXT NOT NULL, "
            + MyColumns.Deskripsi + " TEXT NOT NULL, "
            + MyColumns.Harga + " TEXT NOT NULL, "
            + MyColumns.Foto + " TEXT NOT NULL)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + MyColumns.NamaTabel;

    DbBook(Context context) {
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

//    //Get 1 Data By ID
//    public static Cursor oneData(Long id) {
//        Cursor cur = db.rawQuery("SELECT * FROM " + MyColumns.NamaTabel + " WHERE " + MyColumns.KodeBuku + "=" + id, null);
//        return cur;
//    }


}

