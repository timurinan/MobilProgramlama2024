package com.example.hafta8_uygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txt_adsoyad,txt_mail,txt_doğumtarihi;
    Button buton;
    Spinner spinner_şehiler;

    ArrayList<Müşteri> müşteriler=new ArrayList<Müşteri>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_şehiler=findViewById(R.id.spn_doğumyeri);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.şehirler, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner_şehiler.setAdapter(adapter);

        txt_adsoyad=findViewById(R.id.txt_adsoyad);
        txt_mail=findViewById(R.id.txt_Mail);
        txt_doğumtarihi=findViewById(R.id.txt_doğumtarihi);

        buton=findViewById(R.id.btn_ekle);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adsoyad=txt_adsoyad.getText().toString();
                String mail=txt_mail.getText().toString();
                String şehir=spinner_şehiler.getSelectedItem().toString();
                String doğumtarihi=txt_doğumtarihi.getText().toString();
                Müşteri müşteri=new Müşteri(adsoyad,mail,şehir,doğumtarihi);
                müşteriler.add(müşteri);
                Intent intent=new Intent(MainActivity.this,ListeleActivity.class);
                intent.putExtra("müşteriler",müşteriler);
                startActivity(intent);

            }
        });

        txt_doğumtarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                int gün=calendar.get(Calendar.DAY_OF_MONTH);
                int ay=calendar.get(Calendar.MONTH);
                int yıl=calendar.get(Calendar.YEAR);

                DatePickerDialog dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txt_doğumtarihi.setText(gün+"/"+ay+"/"+yıl);
                    }
                },yıl,ay,gün);
                dpd.show();
            }
        });

           }
}