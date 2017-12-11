package com.eniserkaya.ulkelerhomework;

/**
 * Created by eniserkaya on 11.12.2017.
 */

public class Ulke {

    private String ulkeAdi;
    private int kurulusYili;
    private String kisaBilgi;
    private int ulkeBayragi;
    // R.drawable.bayrak = integer bir deger


    public Ulke(String ulkeAdi, int kurulusYili, String kisaBilgi, int ulkeBayragi) {
        this.ulkeAdi = ulkeAdi;
        this.kurulusYili = kurulusYili;
        this.kisaBilgi = kisaBilgi;
        this.ulkeBayragi = ulkeBayragi;
    }

    public String getUlkeAdi() {
        return ulkeAdi;
    }

    public void setUlkeAdi(String ulkeAdi) {
        this.ulkeAdi = ulkeAdi;
    }

    public int getKurulusYili() {
        return kurulusYili;
    }


    public void setKurulusYili(int kurulusYili) {
        this.kurulusYili = kurulusYili;
    }

    public String getKisaBilgi() {
        return kisaBilgi;
    }

    public void setKisaBilgi(String kisaBilgi) {
        this.kisaBilgi = kisaBilgi;
    }

    public int getUlkeBayragi() {
        return ulkeBayragi;
    }

    public void setUlkeBayragi(int ulkeBayragi) {
        this.ulkeBayragi = ulkeBayragi;
    }
}
