package com.example.hafta13uygulama;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Müşteri> müşteriler;
    Context context;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference dr=firebaseDatabase.getReference("customers");

    public MyAdapter(ArrayList<Müşteri> müşteriler, Context context) {
        this.müşteriler = müşteriler;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent, false);
    return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Müşteri müşteri=müşteriler.get(position);
        holder.txt_mail.setText(müşteri.getMail().toString());
        holder.txt_adsoyad.setText(müşteri.getAdsoyad().toString());

    }

    @Override
    public int getItemCount() {
        return müşteriler.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_adsoyad,txt_mail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_adsoyad=itemView.findViewById(R.id.txt_recyclerview_item_adsoyad);
            txt_mail=itemView.findViewById(R.id.txt_recyclerview_item_mail);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int p=getLayoutPosition();
                    Toast.makeText(itemView.getContext(), "no:"+p, Toast.LENGTH_LONG).show();

                    AlertDialog.Builder dialog=new AlertDialog.Builder(itemView.getContext());
                    dialog.setPositiveButton("Sil", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dr.child(müşteriler.get(p).getUid()).removeValue();
                        }
                    });
                    dialog.setNegativeButton("Güncelle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dr.child(müşteriler.get(p).getUid()).setValue(new Müşteri("Cihan Yılmaz","cyilmaz@outlook.com"));
                        }
                    });
                    dialog.setNeutralButton("Vazgeç", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context.getApplicationContext(), "Vazgeçildi", Toast.LENGTH_LONG).show();
                        }
                    });
                    dialog.show();
                    return false;
                }
            });

        }
    }

}
