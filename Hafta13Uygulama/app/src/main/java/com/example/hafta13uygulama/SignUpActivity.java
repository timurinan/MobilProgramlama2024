package com.example.hafta13uygulama;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.Firebase;

public class SignUpActivity extends AppCompatActivity {

    TextView txt_mail,txt_şifre,txt_şifre_tekrar;

    Button btn_kaydol;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txt_mail=findViewById(R.id.txt_email_signup);
        txt_şifre=findViewById(R.id.txt_password_signup);
        txt_şifre_tekrar=findViewById(R.id.txt_email_signup_tekrar);

        btn_kaydol=findViewById(R.id.btn_signup);

        btn_kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail,şifre;

                if(Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText().toString()).matches()){
                     mail=txt_mail.getText().toString();
                }else{
                    Toast.makeText(SignUpActivity.this, "Yanlış formatlı mail girişi", Toast.LENGTH_LONG).show();
                    return;
                }

                if(txt_şifre.getText().toString().equals(txt_şifre_tekrar.getText().toString())){
                     şifre=txt_şifre.getText().toString();
                }else{
                    Toast.makeText(SignUpActivity.this, "Şifreler uyumsuz...", Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(txt_mail.getText())||TextUtils.isEmpty(txt_şifre.getText())||TextUtils.isEmpty(txt_şifre_tekrar.getText())){
                    Toast.makeText(SignUpActivity.this, "Alanlar boş bırakılamaz.", Toast.LENGTH_LONG).show();
                    return;
                }

                FirebaseAuth fa=FirebaseAuth.getInstance();
                fa.createUserWithEmailAndPassword(mail,şifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            fa.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(SignUpActivity.this, "Mail gönderildi", Toast.LENGTH_SHORT).show();
                                }
                            });
                            Toast.makeText(SignUpActivity.this, "Kullanıcı başarılı şekilde oluşturuldu...", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(SignUpActivity.this, "Kullanıcı oluşturulurken hata meydana geldi..", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
