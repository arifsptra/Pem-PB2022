package com.example.a03basicappdatabase;

import java.util.Objects;

public class MatakuliahModel {
    String kode;
    String nama_mtkl;
    String sks;

    public MatakuliahModel(String kode, String nama_mtkl, String sks) {
        this.kode = kode;
        this.nama_mtkl = nama_mtkl;
        this.sks = sks;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama_mtkl() {
        return nama_mtkl;
    }

    public void setNama_mtkl(String nama_mtkl) {
        this.nama_mtkl = nama_mtkl;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }
}
