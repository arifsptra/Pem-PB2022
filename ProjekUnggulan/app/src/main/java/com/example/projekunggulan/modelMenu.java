package com.example.projekunggulan;

public class modelMenu {
    String nama_menu;
    String harga_menu;
    String satuan_menu;
    int gambar_menu;

    public modelMenu(String nama_menu, String harga_menu, String satuan_menu, int gambar_menu) {
        this.nama_menu = nama_menu;
        this.harga_menu = harga_menu;
        this.satuan_menu = satuan_menu;
        this.gambar_menu = gambar_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getHarga_menu() {
        return harga_menu;
    }

    public void setHarga_menu(String harga_menu) {
        this.harga_menu = harga_menu;
    }

    public String getSatuan_menu() {
        return satuan_menu;
    }

    public void setSatuan_menu(String satuan_menu) {
        this.satuan_menu = satuan_menu;
    }

    public int getGambar_menu() {
        return gambar_menu;
    }

    public void setGambar_menu(int gambar_menu) {
        this.gambar_menu = gambar_menu;
    }
}
