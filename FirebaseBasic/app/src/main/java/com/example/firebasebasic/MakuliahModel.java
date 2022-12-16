package com.example.firebasebasic;

public class MakuliahModel {
    String nip;
    String nama_pegawai;
    String jenis_kel;
    String status;
    String pendidikan;
    String alamat;
    String kota;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getJenis_kel() {
        return jenis_kel;
    }

    public void setJenis_kel(String jenis_kel) {
        this.jenis_kel = jenis_kel;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getPendidikan() { return pendidikan; }

    public void setPendidikan(String pendidikan) { this.pendidikan = pendidikan; }

    public String getAlamat() { return alamat; }

    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getKota() { return kota; }

    public void setKota(String kota) { this.kota = kota; }
}

