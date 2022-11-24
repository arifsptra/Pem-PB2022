package com.example.a03basicappdatabase;

public class ModelMatakuliah {
    String kode, nama_mtkl, sks, syarat;

    public ModelMatakuliah(String kode, String nama_mtkl, String sks, String syarat) {
        this.kode = kode;
        this.nama_mtkl = nama_mtkl;
        this.sks = sks;
        this.syarat = syarat;
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

    public String getSyarat() {
        return syarat;
    }

    public void setSyarat(String syarat) {
        this.syarat = syarat;
    }
}
