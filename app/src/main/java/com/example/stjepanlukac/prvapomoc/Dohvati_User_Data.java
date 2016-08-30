package com.example.stjepanlukac.prvapomoc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Dohvati_User_Data extends AppCompatActivity {
    String username;
    String password;
    public static final String PREFS = "examplePrefs";
    SharedPreferences takeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dohvati__user__data);
        takeData = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        username = takeData.getString("username", "");
        password = takeData.getString("password", "");

        final Button bLogin = (Button) findViewById(R.id.bUcitaj);
        final TextView tvKrv = (TextView) findViewById(R.id.tvKrv);
        final TextView tvTlak1 = (TextView) findViewById(R.id.tvTlak1);
        final TextView tvTlak2 = (TextView) findViewById(R.id.tvTlak2);
        final TextView tvTezina = (TextView) findViewById(R.id.tvTezina);
        final TextView tvVisina = (TextView) findViewById(R.id.tvVisina);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //moramo pretvoriti request u JSON objekt kako bismo mogli raditi s njim
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            //ako je login uspješan, uzmi korisnikove detalje i pošalji u UserAreaActivity
                            if (success) {
                                String krv = jsonResponse.getString("krv");
                                int tlak1 = jsonResponse.getInt("tlak1");
                                String tlakk1 = Integer.toString(tlak1);
                                int tlak2 = jsonResponse.getInt("tlak2");
                                String tlakk2 = Integer.toString(tlak2);
                                double tezina = jsonResponse.getDouble("tezina");
                                String tez = Double.toString(tezina);
                                double visina = jsonResponse.getDouble("visina");
                                String vis = Double.toString(visina);

                                tvKrv.setText(krv);
                                tvTlak1.setText(tlakk1);
                                tvTlak2.setText(tlakk2);
                                tvTezina.setText(tez);
                                tvVisina.setText(vis);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Dohvati_User_Data.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Dohvati_User_Data_Request userReq = new Dohvati_User_Data_Request(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Dohvati_User_Data.this);
                queue.add(userReq);
            }
        });
    }
}
