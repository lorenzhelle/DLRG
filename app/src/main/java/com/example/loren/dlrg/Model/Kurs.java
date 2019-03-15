package com.example.loren.dlrg.Model;

public class Kurs {
    int ID;
    String wochentag;

    public Kurs(int ID, String wochentag) {
        this.ID = ID;
        this.wochentag = wochentag;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getWochentag() {
        return wochentag;
    }

    public void setWochentag(String wochentag) {
        this.wochentag = wochentag;
    }
}
