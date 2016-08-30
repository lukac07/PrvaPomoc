package com.example.stjepanlukac.prvapomoc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Posalji_User_Data extends AppCompatActivity {

    int id = 1;
    String username;
    String password;
    public static final String PREFS = "examplePrefs";
    SharedPreferences takeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posalji__user__data);

        //reference na polja u activity_register-u
        final EditText etKrv = (EditText) findViewById(R.id.etKrv);
        final EditText etTlak1 = (EditText) findViewById(R.id.etTlak1);
        final EditText etTlak2 = (EditText) findViewById(R.id.etTlak2);
        final EditText etTezina = (EditText) findViewById(R.id.etTezina);
        final EditText etVisina = (EditText) findViewById(R.id.etVisina);
        final Button bSpremiPodatke = (Button) findViewById(R.id.bSpremiPodatke);

        takeData = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        username = takeData.getString("username", "");
        password = takeData.getString("password", "");

        bSpremiPodatke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String krv = etKrv.getText().toString();    //uzima tekst koji je korisnik upisao i pretvara ga u string
                final int tlak1 = Integer.parseInt(etTlak1.getText().toString());
                final int tlak2 = Integer.parseInt(etTlak2.getText().toString());
                final double tezina = Double.parseDouble(etTezina.getText().toString());
                final double visina = Double.parseDouble(etVisina.getText().toString());



                //kreiranje request-a
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(Posalji_User_Data.this, Dohvati_User_Data.class);
                                Posalji_User_Data.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Posalji_User_Data.this);
                                builder.setMessage("Spremanje neuspjesno")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                Posalji_User_Data_Request registerRequest = new Posalji_User_Data_Request(username, password, krv, tlak1, tlak2, tezina, visina, id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Posalji_User_Data.this);
                queue.add(registerRequest);
            }
        });
    }
}
