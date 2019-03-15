package com.example.loren.dlrg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.loren.dlrg.Model.Person;
import com.example.loren.dlrg.Model.VolleyService;
import com.example.loren.dlrg.interfaces.ApiResult;

import org.json.JSONArray;

public class MainListActivity extends AppCompatActivity implements PersonFragment.OnListFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);


    }

    @Override
    public void onListFragmentInteraction(Person person) {
        Toast.makeText(getApplicationContext(),"Wer hat gelickt?" + person.getName(),Toast.LENGTH_LONG).show();
    }


}
