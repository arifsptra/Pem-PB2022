package com.example.apppenjualanbarang;

import java.util.ArrayList;

public interface LoadAlatKesehatanCallback {
    void preExecute();

    void postExecute(ArrayList<AlatKesehatan> alatKesehatan);
}
