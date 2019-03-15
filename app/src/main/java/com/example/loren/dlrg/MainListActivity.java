package com.example.loren.dlrg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.loren.dlrg.Model.Kurs;

public class MainListActivity extends AppCompatActivity implements PersonFragment.OnListFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);


    }

    @Override
    public void onListFragmentInteraction(Kurs kurs) {
        Toast.makeText(getApplicationContext(),"Wer hat gelickt?" + kurs.getID(),Toast.LENGTH_LONG).show();
    }


}
