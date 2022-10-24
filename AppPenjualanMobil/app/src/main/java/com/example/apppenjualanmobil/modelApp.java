package com.example.apppenjualanmobil;

public class modelApp {
    String nama_mobil;
    String kode_mobil;
    String satuan_mobil;
    String harga_mobil;
    int image_mobil;

    public modelApp(String nama_mobil, String kode_mobil, String satuan_mobil, String harga_mobil, int image_mobil) {
        this.nama_mobil = nama_mobil;
        this.kode_mobil = kode_mobil;
        this.satuan_mobil = satuan_mobil;
        this.harga_mobil = harga_mobil;
        this.image_mobil = image_mobil;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getKode_mobil() {
        return kode_mobil;
    }

    public void setKode_mobil(String kode_mobil) {
        this.kode_mobil = kode_mobil;
    }

    public String getSatuan_mobil() {
        return satuan_mobil;
    }

    public void setSatuan_mobil(String satuan_mobil) {
        this.satuan_mobil = satuan_mobil;
    }

    public String getHarga_mobil() {
        return harga_mobil;
    }

    public void setHarga_mobil(String harga_mobil) {
        this.harga_mobil = harga_mobil;
    }

    public int getImage_mobil() {
        return image_mobil;
    }

    public void setImage_mobil(int image_mobil) {
        this.image_mobil = image_mobil;
    }
}
