package com.example.hafta8_uygulama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Müşteri> müşteriler;
    LayoutInflater inflater;

    public MyAdapter(ArrayList<Müşteri> müşteriler, Context context) {
        this.müşteriler = müşteriler;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.activity_recyclerview_item,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Müşteri müşteri=müşteriler.get(position);
        holder.setData(müşteri,position);
    }

    @Override
    public int getItemCount() {
        return müşteriler.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_adsoyad,txt_mail,txt_şehir,txt_doğumtarihi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_adsoyad=itemView.findViewById(R.id.textView4);
            txt_mail=itemView.findViewById(R.id.textView5);
            txt_şehir=itemView.findViewById(R.id.textView6);
            txt_doğumtarihi=itemView.findViewById(R.id.textView7);

        }
        public void setData(Müşteri müşteri,int position){
            txt_adsoyad.setText(müşteri.getAdsoyad());
            txt_mail.setText(müşteri.getMail());
            txt_şehir.setText(müşteri.getŞehir());
            txt_doğumtarihi.setText(müşteri.getDoğumtarihi());
        }
    }


}
