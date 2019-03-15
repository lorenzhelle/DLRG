package com.example.loren.dlrg.Model;

public class Kurs {
    int ID;
    String bezeichnung;
    String wochentag;
    String uhrzeit;

    public Kurs(int ID, String wochentag) {
        this.ID = ID;
        this.wochentag = wochentag;
    }

    public Kurs(int ID, String bezeichnung, String wochentag, String uhrzeit) {
        this.ID = ID;
        this.bezeichnung = bezeichnung;
        this.wochentag = wochentag;
        this.uhrzeit = uhrzeit;
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

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }
}
