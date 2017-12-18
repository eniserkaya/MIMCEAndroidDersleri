package com.eniserkaya.firebaseintro;

/**
 * Created by eniserkaya on 18.12.2017.
 */

public class Message {

    String mesaj;
    String kisi;

    public Message(){}
    public Message(String mesaj, String kisi) {
        this.mesaj = mesaj;
        this.kisi = kisi;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getKisi() {
        return kisi;
    }

    public void setKisi(String kisi) {
        this.kisi = kisi;
    }
}


