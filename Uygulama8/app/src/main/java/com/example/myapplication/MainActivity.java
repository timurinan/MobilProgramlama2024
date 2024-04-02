package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vp;
    FragmentAdapter fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp=findViewById(R.id.viewPager2);

        fa=new FragmentAdapter(getSupportFragmentManager(),getLifecycle());

        Hesap hesap1=new Hesap("Timur İnan","Dolar",30000);
        Hesap hesap2=new Hesap("Mehmet Yurdakul","Türk Lirası",50000);
        Hesap hesap3=new Hesap("Cengiz Türkoğlu","Euro",600);

        Fragment_Hesap fragmentHesap1=new Fragment_Hesap();
        fragmentHesap1.setHesap(hesap1);

        Fragment_Hesap fragmentHesap2=new Fragment_Hesap();
        fragmentHesap2.setHesap(hesap2);

        Fragment_Hesap fragmentHesap3=new Fragment_Hesap();
        fragmentHesap3.setHesap(hesap3);

        fa.addFragment(fragmentHesap1);
        fa.addFragment(fragmentHesap2);
        fa.addFragment(fragmentHesap3);

        vp.setAdapter(fa);

    }
}