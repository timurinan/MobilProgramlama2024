package com.example.hafta13uygulama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView txt_mail,txt_şifre,txt_şifre_unuttum,txt_kaydol;

    Button btn_giriş;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_mail=findViewById(R.id.txt_mail_login);
        txt_şifre=findViewById(R.id.txt_password_login);
        txt_şifre_unuttum=findViewById(R.id.txt_şifre_unuttum);
        txt_kaydol=findViewById(R.id.txt_hesap_oluştur);

        FirebaseAuth fa=FirebaseAuth.getInstance();

        btn_giriş=findViewById(R.id.btn_giriş);

        txt_kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        txt_şifre_unuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        btn_giriş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fa.signInWithEmailAndPassword(txt_mail.getText().toString(),txt_şifre.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(fa.getCurrentUser().isEmailVerified()&&task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Giriş başarılı...", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Giriş başarısız", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}