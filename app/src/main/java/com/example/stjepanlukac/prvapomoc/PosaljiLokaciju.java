package com.example.stjepanlukac.prvapomoc;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PosaljiLokaciju extends Fragment {


    public PosaljiLokaciju() {
        // Required empty public constructor
    }

    Button posalji_Lokaciju;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_posalji_lokaciju, container, false);

        posalji_Lokaciju = (Button) view.findViewById(R.id.posalji_lokaciju);

        posalji_Lokaciju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent posalji_Lokaciju = new Intent(view.getContext(), Lokacija.class);
                view.getContext().startActivity(posalji_Lokaciju);
            }
        });
        return view;
    }
}


