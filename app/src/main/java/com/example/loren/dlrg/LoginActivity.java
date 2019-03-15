package com.example.loren.dlrg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity  {

    private static final String PIN_ACCESS_SHARED = "pin";
    EditText pinInput;
    ImageView confirmPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pinInput = (EditText)findViewById(R.id.pin);
        confirmPin = (ImageView)findViewById(R.id.confirmPin);

        setPin("1234");

        Log.d("PIN","AKtuelle Pin: " + getPin());
        confirmPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPin();
            }
        });



    }

    private void checkPin() {
        if(pinInput.getText()!=null){
            String pin = pinInput.getText().toString();
            if(pin.equals(getPin())&&getPin()!=null){
                Intent intent = new Intent(LoginActivity.this,MainListActivity.class);
                startActivity(intent);
            }else{
                if(pin.equals("")){
                    pinInput.setError("Bitte Pin eingeben");
                } else{
                    pinInput.setError(getString(R.string.wrongPin));
                }

            }
        }
    }

    /**
     *
     * @return current Pin for Login
     */
    private String getPin(){
        SharedPreferences preferences = getSharedPreferences("access",MODE_PRIVATE);
        return preferences.getString("pin",null);
    }

    /**
     * Save new Pin to shared Preferences
     * @param pin chosen Pin
     */
    private void setPin(String pin){
        SharedPreferences preferences = getSharedPreferences("access",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PIN_ACCESS_SHARED,pin);
        editor.commit();
    }



}
