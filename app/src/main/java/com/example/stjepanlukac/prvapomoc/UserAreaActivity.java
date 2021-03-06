package com.example.stjepanlukac.prvapomoc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class UserAreaActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public static final String PREFS = "examplePrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        //referenca na toolbar kad sam radio tabove
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new PrvaPomoc(), "Prva pomoc");
        viewPagerAdapter.addFragments(new PosaljiLokaciju(), "Dohvati lokaciju");
        viewPagerAdapter.addFragments(new TreciFragment(), "Korisnički podaci");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //meni koji dovodi do registriranja/logiranja
        switch (item.getItemId()){
            case R.id.menu_Log_Reg:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent intent = new Intent(UserAreaActivity.this, LoginActivity.class);
                UserAreaActivity.this.startActivity(intent);
                return true;

            case R.id.menu_Logout:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                SharedPreferences.Editor editor = examplePrefs.edit();
                editor.clear();
                editor.commit();
                boolean chkUser = true;
                editor.putBoolean("chkUser", chkUser);
                editor.commit();

                Intent i = new Intent(UserAreaActivity.this, UserAreaActivity.class);
                UserAreaActivity.this.startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

