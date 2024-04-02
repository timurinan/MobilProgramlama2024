package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DecimalFormat;
import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    TextView txt_anapara, txt_faiz, txt_aylıkfaiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_anapara=findViewById(R.id.editTextNumber);
        txt_faiz=findViewById(R.id.editTextNumber2);
        txt_aylıkfaiz=findViewById(R.id.textView3);

        txt_anapara.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hesaplamaYap();
            }
        });

        txt_faiz.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hesaplamaYap();
            }
        });
    }

    private void hesaplamaYap() {
        if(txt_anapara.getText().length()!=0&&txt_faiz.getText().length()!=0){
            double anapara= Double.valueOf(txt_anapara.getText().toString());
            double yıllıkfaiz=Double.valueOf(txt_faiz.getText().toString());
            double aylıkfaiz=(anapara*yıllıkfaiz/100)/12;
            DecimalFormat df=new DecimalFormat("#.###");
            txt_aylıkfaiz.setText( df.format(aylıkfaiz)+ "TL");
        }else{
            Toast.makeText(getApplicationContext(),"Ana para veya faiz girilmelidir",Toast.LENGTH_LONG ).show();
        }

    }
}