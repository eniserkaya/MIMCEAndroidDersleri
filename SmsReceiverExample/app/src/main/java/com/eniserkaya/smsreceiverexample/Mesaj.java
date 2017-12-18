package com.eniserkaya.smsreceiverexample;

/**
 * Created by eniserkaya on 18.12.2017.
 */

public class Mesaj {

    private String gondericiAdi;
    private String gelenMesaj;

    public Mesaj(String gondericiAdi, String gelenMesaj) {
        this.gondericiAdi = gondericiAdi;
        this.gelenMesaj = gelenMesaj;
    }

    public String getGondericiAdi() {
        return gondericiAdi;
    }

    public void setGondericiAdi(String gondericiAdi) {
        this.gondericiAdi = gondericiAdi;
    }

    public String getGelenMesaj() {
        return gelenMesaj;
    }

    public void setGelenMesaj(String gelenMesaj) {
        this.gelenMesaj = gelenMesaj;
    }
}
