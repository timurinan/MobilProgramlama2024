package com.example.hafta8_uygulama;

import java.io.Serializable;

public class Müşteri implements Serializable {

    private String adsoyad,mail,şehir,doğumtarihi;

    public Müşteri(String adsoyad, String mail, String şehir, String doğumtarihi) {
        this.adsoyad = adsoyad;
        this.mail = mail;
        this.şehir = şehir;
        this.doğumtarihi = doğumtarihi;
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

    public String getŞehir() {
        return şehir;
    }

    public void setŞehir(String şehir) {
        this.şehir = şehir;
    }

    public String getDoğumtarihi() {
        return doğumtarihi;
    }

    public void setDoğumtarihi(String doğumtarihi) {
        this.doğumtarihi = doğumtarihi;
    }
}
