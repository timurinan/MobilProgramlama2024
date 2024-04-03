package com.example.hafta8_uygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ListeleActivity extends AppCompatActivity {

    FloatingActionButton fab;

    ArrayList<Müşteri> müşteriler=new ArrayList<Müşteri>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        fab=findViewById(R.id.floatingActionButton);
        recyclerView=findViewById(R.id.recyclerView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListeleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        /*müşteriler.add(new Müşteri("Timur","timurinan@hotmail.com","İstanbul","06/08/1979"));
        müşteriler.add(new Müşteri("Ahmet","ahmet@hotmail.com","Ankara","06/08/1979"));
        müşteriler.add(new Müşteri("Mehmet","mehmet@hotmail.com","İzmir","06/08/1979"));*/
        müşteriler= (ArrayList<Müşteri>) getIntent().getSerializableExtra("müşteriler");

        MyAdapter adapter=new MyAdapter(müşteriler,getApplicationContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }
}
