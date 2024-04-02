package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_adsoyad,txt_mail,txt_Telefon;
    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_adsoyad=findViewById(R.id.txt_AdSoyad);
        txt_mail=findViewById(R.id.txt_Mail);
        txt_Telefon=findViewById(R.id.txt_TelefonNo);

        buton=findViewById(R.id.btn_Kaydol);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(txt_adsoyad.getText())){

                    if(Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){

                        if(PhoneNumberUtils.isGlobalPhoneNumber(txt_Telefon.getText().toString())){

                            Müşteri müşteri=new Müşteri(txt_adsoyad.getText().toString(),txt_mail.getText().toString(),txt_Telefon.getText().toString());

                            Intent intent=new Intent(getApplicationContext(),KayıtActivity.class);
                            intent.putExtra("müşteri",müşteri);
                            startActivity(intent);

                        }else{
                            Toast.makeText(MainActivity.this, "Telefon numarası doğru girilmeli...", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(MainActivity.this, "Mail formata uygun değildir...", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Ad Soyad Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}