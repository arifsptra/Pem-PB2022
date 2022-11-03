package com.example.apppenjualanbarang;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_NAME = "alatkesehatan";

    public static final class AlatKesehatanColumns implements BaseColumns {
        public static String KODE = "kode";
        public static String NAMA = "nama";
        public static String SATUAN = "satuan";
        public static String HARGA = "harga";
        public static String JUMLAH = "jumlah";
        public static String GAMBAR = "gambar";
        public static String STOK = "stok";
        public static String TERJUAL = "terjual";
    }
}