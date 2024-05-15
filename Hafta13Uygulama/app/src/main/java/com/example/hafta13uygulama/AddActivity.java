package com.example.hafta13uygulama;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    TextView txt_adsoyad,txt_mail;

    Button buton;

    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference dr=fd.getReference("customers");
    DatabaseReference drwithkey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txt_adsoyad=findViewById(R.id.txt_addactivity_adsoyad);
        txt_mail=findViewById(R.id.txt_addactivity_mail);

        buton=findViewById(R.id.btn_addactivity);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adsoyad=txt_adsoyad.getText().toString();
                String mail=txt_mail.getText().toString();
                Müşteri müşteri=new Müşteri(adsoyad,mail);
                String key=dr.push().getKey();
                drwithkey=fd.getReference("customers/"+key);
                Müşteri customer=new Müşteri(adsoyad,mail);
                müşteri.setUid(key);
                drwithkey.setValue(müşteri);
                Intent intent=new Intent(AddActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });

    }
}
