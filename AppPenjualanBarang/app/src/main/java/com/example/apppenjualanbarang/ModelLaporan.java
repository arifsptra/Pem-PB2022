package com.example.apppenjualanbarang;

import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.GAMBAR;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.HARGA;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.JUMLAH;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.KODE;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.NAMA;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.SATUAN;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.STOK;
import static com.example.apppenjualanbarang.DatabaseContract.AlatKesehatanColumns.TERJUAL;

public class ModelLaporan {
    String kode,nama,satuan,harga,stok,terjual,sisa;
    String gambar;
    public ModelLaporan() {
        this.kode = KODE;
        this.gambar = GAMBAR;
        this.nama = NAMA;
        this.satuan = SATUAN;
        this.stok = STOK;
        this.harga = HARGA;
        this.terjual = TERJUAL;
        this.sisa = JUMLAH;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public String getHarga() {
        return harga;
    }

    public String getStok() {
        return stok;
    }

    public String getTerjual() {
        return terjual;
    }

    public String getSisa() {
        return sisa;
    }

    public String getGambar() {
        return gambar;
    }
}
