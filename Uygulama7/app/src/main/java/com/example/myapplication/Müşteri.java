package com.example.myapplication;

import java.io.Serializable;

public class Müşteri implements Serializable {

    private String adsoyad,mail,telefonno;

    public Müşteri(String adsoyad, String mail, String telefonno) {
        this.adsoyad = adsoyad;
        this.mail = mail;
        this.telefonno = telefonno;
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

    public String getTelefonno() {
        return telefonno;
    }

    public void setTelefonno(String telefonno) {
        this.telefonno = telefonno;
    }
}
