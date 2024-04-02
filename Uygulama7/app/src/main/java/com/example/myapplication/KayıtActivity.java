package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KayıtActivity extends AppCompatActivity {

    TextView txt_Bilgi;
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        txt_Bilgi=findViewById(R.id.editTextTextMultiLine);

        iv=findViewById(R.id.imageView);

        Müşteri müşteri=getIntent().getSerializableExtra("müşteri",Müşteri.class);

        txt_Bilgi.setText("Merhaba Sayın, "+müşteri.getAdsoyad()+"\n"+"Telefon Numaranız:"+müşteri.getTelefonno()+"\n"+"Mail adresiniz: "+müşteri.getMail());


    }
}
