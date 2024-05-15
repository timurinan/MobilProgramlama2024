package com.example.hafta13uygulama;

public class Müşteri {

    private String adsoyad,mail,uid;

    public Müşteri() {
    }

    public Müşteri(String adsoyad, String mail) {
        this.adsoyad = adsoyad;
        this.mail = mail;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
