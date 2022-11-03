package com.example.apppenjualanbarang;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class AlatKesehatan extends ArrayList<Parcelable> implements Parcelable {
    public int id;
    public String kode;
    public String nama;
    public String satuan;
    public String harga;
    public String jumlah;
    public String gambar;
    public String stok;
    public String terjual;

    @NonNull
    @Override
    public Stream<Parcelable> stream() {
        return super.stream();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.kode);
        dest.writeString(this.nama);
        dest.writeString(this.satuan);
        dest.writeString(this.harga);
        dest.writeString(this.jumlah);
        dest.writeString(this.gambar);
        dest.writeString(this.stok);
        dest.writeString(this.terjual);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.kode = source.readString();
        this.nama = source.readString();
        this.satuan = source.readString();
        this.harga = source.readString();
        this.jumlah = source.readString();
        this.gambar = source.readString();
        this.stok = source.readString();
        this.terjual = source.readString();
    }

    public AlatKesehatan() {
    }

    protected AlatKesehatan(Parcel in) {
        this.id = in.readInt();
        this.kode = in.readString();
        this.nama = in.readString();
        this.satuan = in.readString();
        this.harga = in.readString();
        this.jumlah = in.readString();
        this.gambar = in.readString();
        this.stok = in.readString();
        this.terjual = in.readString();
    }

    public static final Creator<AlatKesehatan> CREATOR = new Creator<AlatKesehatan>() {
        @Override
        public AlatKesehatan createFromParcel(Parcel source) {
            return new AlatKesehatan(source);
        }

        @Override
        public AlatKesehatan[] newArray(int size) {
            return new AlatKesehatan[size];
        }
    };
}
