package com.example.hafta13uygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView recycler;

    ArrayList<Müşteri> müşteriler=new ArrayList<>();

    FloatingActionButton fab;

    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference dr=fd.getReference("customers");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recycler=findViewById(R.id.listactivity_recycler);

        fab=findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });

        MyAdapter adapter=new MyAdapter(müşteriler,getApplicationContext());

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                müşteriler.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Müşteri müşteri=dataSnapshot.getValue(Müşteri.class);
                    müşteri.setUid(dataSnapshot.getKey());
                    System.out.println(müşteri.toString());
                    müşteriler.add(müşteri);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recycler.setLongClickable(true);

}}
