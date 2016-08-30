package com.example.stjepanlukac.prvapomoc;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class TreciFragment extends Fragment {


    public TreciFragment() {
        // Required empty public constructor
    }


    Button podaciKorisnika, unosPodataka;
    TextView korisnik, godine;
    String username;
    int age;
    public static final String PREFS = "examplePrefs";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_treci, container, false);
        //textview username(Ime prezime korisnika
        //textview age
        podaciKorisnika = (Button) view.findViewById(R.id.bPodaciKorisnika);
        unosPodataka = (Button) view.findViewById(R.id.bUnesiPodatkeKorisnika);
        korisnik = (TextView) view.findViewById(R.id.txKoirisnik);
        godine = (TextView) view.findViewById(R.id.txGodine);


        Bundle extras = getActivity().getIntent().getExtras();


        SharedPreferences takeData;
        takeData = this.getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);

        if(extras != null)
        {
            Boolean check = extras.getBoolean("chkUser");
            if(check == true){
                korisnik.setText("");
                godine.setText("");
            }
            //else
                //Toast.makeText(view.getContext(), "!", Toast.LENGTH_SHORT).show();
        }
        username = takeData.getString("username", "");
        age = takeData.getInt("age", 365);
        korisnik.setText(username);
        if(age != 365)
            godine.setText(String.valueOf(age));
        else
            godine.setText("");

        podaciKorisnika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Dohvati_User_Data.class);
                view.getContext().startActivity(intent);
            }
        });
        unosPodataka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Posalji_User_Data.class);
                view.getContext().startActivity(intent);
            }
        });
        return view;
    }
}
