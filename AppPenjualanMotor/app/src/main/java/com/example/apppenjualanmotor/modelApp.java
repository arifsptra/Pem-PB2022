package com.example.apppenjualanmotor;

public class modelApp {
    String nama_motor;
    String kode_motor;
    int harga_motor;
    int stok_motor;
    String tampilan_harga;
    int gambar_motor;

    public modelApp(String nama_motor, String kode_motor, int harga_motor, int stok_motor, String tampilan_harga, int gambar_motor) {
        this.nama_motor = nama_motor;
        this.kode_motor = kode_motor;
        this.harga_motor = harga_motor;
        this.stok_motor = stok_motor;
        this.tampilan_harga = tampilan_harga;
        this.gambar_motor = gambar_motor;
    }

    public String getNama_motor() {
        return nama_motor;
    }

    public void setNama_motor(String nama_motor) {
        this.nama_motor = nama_motor;
    }

    public String getKode_motor() {
        return kode_motor;
    }

    public void setKode_motor(String kode_motor) {
        this.kode_motor = kode_motor;
    }

    public int getHarga_motor() {
        return harga_motor;
    }

    public void setHarga_motor(int harga_motor) {
        this.harga_motor = harga_motor;
    }

    public int getStok_motor() {
        return stok_motor;
    }

    public void setStok_motor(int stok_motor) {
        this.stok_motor = stok_motor;
    }

    public String getTampilan_harga() {
        return tampilan_harga;
    }

    public void setTampilan_harga(String tampilan_harga) {
        this.tampilan_harga = tampilan_harga;
    }

    public int getGambar_motor() {
        return gambar_motor;
    }

    public void setGambar_motor(int gambar_motor) {
        this.gambar_motor = gambar_motor;
    }
}
