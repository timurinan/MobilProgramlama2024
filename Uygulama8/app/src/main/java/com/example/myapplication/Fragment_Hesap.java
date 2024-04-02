package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Hesap extends Fragment {

    TextView txt_adsoyad,txt_tür,txt_bakiye;

    Hesap hesap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.hesap_layout,container,false);
        txt_adsoyad=view.findViewById(R.id.txt_adsoyad);
        txt_tür=view.findViewById(R.id.txt_hesaptürü);
        txt_bakiye=view.findViewById(R.id.txt_bakiye);

        txt_adsoyad.setText(hesap.getHesapsahibi().toString());
        txt_tür.setText(hesap.getHesaptürü().toString());
        txt_bakiye.setText(hesap.getBakiye()+"");

        return view;
    }

    public void setHesap(Hesap hesap){
        this.hesap=hesap;
    }
}
