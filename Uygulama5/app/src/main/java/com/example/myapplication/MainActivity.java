package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_vize_not, txt_final_not,txt_lab_not, txt_vize_ağırlık, txt_final_ağırlık,txt_lab_ağırlık,txt_ortalama;
    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_vize_not=findViewById(R.id.editTextNumber);
        txt_final_not=findViewById(R.id.editTextNumber2);
        txt_lab_not=findViewById(R.id.editTextNumber3);

        txt_vize_ağırlık=findViewById(R.id.editTextNumber5);
        txt_final_ağırlık=findViewById(R.id.editTextNumber7);
        txt_lab_ağırlık=findViewById(R.id.editTextNumber8);
        txt_ortalama=findViewById(R.id.textView);

        buton=findViewById(R.id.button);

        buton.setOnClickListener(v -> hesaplamaYap());
    }

    private void hesaplamaYap(){
        if (txt_vize_not.getText().length()!=0&&txt_final_not.getText().length()!=0&&txt_lab_not.getText().length()!=0){

            if(txt_vize_ağırlık.getText().length()!=0&&txt_final_ağırlık.getText().length()!=0&&txt_lab_ağırlık.getText().length()!=0){

                double vize_ağırlık=Double.valueOf(txt_vize_ağırlık.getText().toString());
                double final_ağırlık=Double.valueOf(txt_final_ağırlık.getText().toString());
                double lab_ağırlık=Double.valueOf(txt_lab_ağırlık.getText().toString());

                if(vize_ağırlık+final_ağırlık+lab_ağırlık==100){

                    double vize_not=Double.valueOf(txt_vize_not.getText().toString());
                    double final_not=Double.valueOf(txt_final_not.getText().toString());
                    double lab_not=Double.valueOf(txt_lab_not.getText().toString());

                    if((vize_not>=0&&vize_not<=100)&&(final_not>=0&&final_not<=100)&&(lab_not>=0&&lab_not<=100)){
                        double ortalama=(final_not*final_ağırlık/100)+(vize_not*vize_ağırlık/100)+(lab_not*lab_ağırlık/100);
                        txt_ortalama.setText("Notunuz:"+ortalama);
                    }else{
                        Toast.makeText(getApplicationContext(),"Notlar 0 ile 100 arasında olmalıdır....",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Ağırlıklar toplamı 100 olmalıdır..", Toast.LENGTH_LONG).show();
                }

            }else{
                Toast.makeText(getApplicationContext(),"Not ağırlıkları boş bırakılamaz...",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(getApplicationContext(),"Vize,Final veya Lab alanları boş bırakılamaz.",Toast.LENGTH_LONG).show();
        }
    }
}