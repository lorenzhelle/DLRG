package com.example.loren.dlrg.Model;

import java.util.ArrayList;

public class PersonDatabase {

    public static ArrayList<Kurs> getSampleListOfPersons(){
        ArrayList <Kurs> sampleData = new ArrayList<>();
        sampleData.add(new Kurs(1,"DIenstag"));
        sampleData.add(new Kurs(2,"Donnerstag"));
        return sampleData;
    }





}
