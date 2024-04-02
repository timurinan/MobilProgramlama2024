package com.example.myapplication;

import java.io.Serializable;

public class Müşteri implements Serializable {

    private String adsoyad,mail,doğumtarihi,şehir;

    public Müşteri(String adsoyad, String mail, String doğumtarihi, String şehir) {
        this.adsoyad = adsoyad;
        this.mail = mail;
        this.doğumtarihi = doğumtarihi;
        this.şehir = şehir;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDoğumtarihi() {
        return doğumtarihi;
    }

    public void setDoğumtarihi(String doğumtarihi) {
        this.doğumtarihi = doğumtarihi;
    }

    public String getŞehir() {
        return şehir;
    }

    public void setŞehir(String şehir) {
        this.şehir = şehir;
    }

    @Override
    public String toString() {
        return "Müşteri{" +
                "adsoyad='" + adsoyad + '\'' +
                ", mail='" + mail + '\'' +
                ", doğumtarihi='" + doğumtarihi + '\'' +
                ", şehir='" + şehir + '\'' +
                '}';
    }
}
