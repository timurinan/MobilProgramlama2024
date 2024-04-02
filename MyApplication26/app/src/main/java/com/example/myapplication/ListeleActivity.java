package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListeleActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FloatingActionButton fab;

    ArrayList<Müşteri> müşteriler=new ArrayList<Müşteri>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_musteri_listele);
        recyclerView=findViewById(R.id.recyclerView);
        fab=findViewById(R.id.floatingActionButton);

        müşteriler= (ArrayList<Müşteri>) getIntent().getExtras().getSerializable("müşteriler");

        Log.d("işte",müşteriler.toString());
        MyAdapter ma=new MyAdapter(müşteriler,getApplicationContext());
        recyclerView.setAdapter(ma);


        LinearLayoutManager lm=new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        fab.setOnClickListener(v -> ekle());

    }

    private void ekle() {

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("müşteriler",müşteriler);
        intent.putExtra("adet",müşteriler.size());
        startActivity(intent);
    }
}
