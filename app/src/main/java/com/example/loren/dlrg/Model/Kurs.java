package com.example.loren.dlrg.Model;

import java.util.ArrayList;

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

    /**
     * Für Testzwecke geschrieben, für Offlinedaten
     * @return
     */
    public static ArrayList<Kurs> getTestData(){

        Kurs kurs = new Kurs(1,"Bronze","Donnerstag","12.00");
        Kurs kurs2 = new Kurs(2,"Silber","Mittwoch","12.00");
        Kurs kurs3 = new Kurs(3,"Gold","Dienstag","12.00");
        Kurs kurs4 = new Kurs(4,"Seepferdchen","Donnerstag","12.00");
        ArrayList<Kurs> kurseMock = new ArrayList<>();
        kurseMock.add(kurs);
        kurseMock.add(kurs2);
        kurseMock.add(kurs3);
        kurseMock.add(kurs4);
        return kurseMock;
    }
}
