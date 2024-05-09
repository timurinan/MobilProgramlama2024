package com.example.hafta13uygulama;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {


    TextView txt_mail;

    Button btn_reset;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        txt_mail=findViewById(R.id.txt_email_forgot_password);

        btn_reset=findViewById(R.id.btn_password_reset);

        FirebaseAuth fa=FirebaseAuth.getInstance();

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fa.sendPasswordResetEmail(txt_mail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ResetPasswordActivity.this, "Şifre resetlendi", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ResetPasswordActivity.this, "Şifre resetleme başarısız", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
