package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    ArrayList<Müşteri> müşteriler;
    LayoutInflater inflater;

    public MyAdapter(ArrayList<Müşteri> müşteriler, Context context) {
        this.müşteriler = müşteriler;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recylerview_musteri,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Müşteri seçilenmüşteri=müşteriler.get(position);
        holder.setData(seçilenmüşteri,position);
    }

    @Override
    public int getItemCount() {
        return müşteriler.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_adsoyad,txt_mail,txt_doğumtarihi,txt_şehir;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_adsoyad=itemView.findViewById(R.id.textView2);
            txt_mail=itemView.findViewById(R.id.textView3);
            txt_şehir=itemView.findViewById(R.id.textView4);
            txt_doğumtarihi=itemView.findViewById(R.id.textView5);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder ab=new AlertDialog.Builder(itemView.getContext());
                    ab.setTitle("Silmek istediğinizden eminmisiniz?");
                    ab.setNegativeButton("Sil", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ab.setPositiveButton("Vazgeç", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ab.show();
                    return false;
                }
            });
        }

        public void setData(Müşteri müşteri,int position){
            txt_adsoyad.setText(müşteri.getAdsoyad().toString());
            txt_mail.setText(müşteri.getMail().toString());
            txt_doğumtarihi.setText(müşteri.getDoğumtarihi().toString());
            txt_şehir.setText(müşteri.getŞehir().toString());
        }


    }
}
