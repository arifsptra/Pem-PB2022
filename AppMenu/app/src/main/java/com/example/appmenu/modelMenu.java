package com.example.appmenu;

public class modelMenu {
    String nama_menu;
    String harga_menu;
    String satuan_menu;
    int image_menu;

    public modelMenu(String nama_menu, String harga_menu, String satuan_menu, int image_menu) {
        this.nama_menu = nama_menu;
        this.harga_menu = harga_menu;
        this.satuan_menu = satuan_menu;
        this.image_menu = image_menu;
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

    public String getSatuan_menu() { return satuan_menu; }

    public void setSatuan_menu(String satuan_menu) { this.satuan_menu = satuan_menu; }

    public int getImage_menu() {
        return image_menu;
    }

    public void setImage_menu(int image_menu) {
        this.image_menu = image_menu;
    }
}
