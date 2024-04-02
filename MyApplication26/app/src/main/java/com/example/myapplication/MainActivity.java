package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txt_adsoyad,txt_mail,txt_doğumtarihi;
    Spinner spinner;

    ArrayList<Müşteri> müşteriler=new ArrayList<Müşteri>();

    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int adet=getIntent().getIntExtra("adet",0);
        if(adet!=0)
        müşteriler= (ArrayList<Müşteri>) getIntent().getExtras().getSerializable("müşteriler");

        spinner=findViewById(R.id.spinner);
        txt_adsoyad=findViewById(R.id.autoCompleteTextView);
        txt_mail=findViewById(R.id.editTextTextEmailAddress);
        txt_doğumtarihi=findViewById(R.id.editTextDate);
        buton=findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.şehirler, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        txt_doğumtarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txt_doğumtarihi.setText(year+"/"+month+"/"+dayOfMonth);
                    }
                },year,month,day);
                dpd.show();
            }
        });

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adsoyad=txt_adsoyad.getText().toString();
                String mail=txt_mail.getText().toString();
                String şehir=spinner.getSelectedItem().toString();
                String doğumtarihi=txt_doğumtarihi.getText().toString();
                müşteriler.add(new Müşteri(adsoyad,mail,şehir,doğumtarihi));

                Intent intent=new Intent(getApplicationContext(),ListeleActivity.class);
                intent.putExtra("müşteriler",müşteriler);
                startActivity(intent);
            }
        });

    }
}