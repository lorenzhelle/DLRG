package com.example.loren.dlrg.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PersonDatabase {

    public static ArrayList<Person> getSampleListOfPersons(){
        ArrayList <Person> sampleData = new ArrayList<>();
        sampleData.add(new Person(1,"Lorenz"));
        sampleData.add(new Person(2,"Markus"));
        return sampleData;
    }





}
