package com.example.stjepanlukac.prvapomoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        //reference na polja u activity_user_area
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);

        //vraćanje podataka koje smo poslali iz LoginActivitija kada se logiramo
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);    // -1 ide zbog godina da bude defaultno

        //postavljanje poruke
        String message = name + " welcome to your user area";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etAge.setText(age + "");
    }
}
