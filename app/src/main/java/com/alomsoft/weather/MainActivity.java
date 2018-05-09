package com.alomsoft.weather;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        transaction = getSupportFragmentManager().beginTransaction();
        CelsiusFragment celsiusFragment = new CelsiusFragment();
        transaction.add(R.id.frame_layout,celsiusFragment);
        transaction.commit();

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_menu);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.celsius:
                        fragment = new CelsiusFragment();
                        break;
                    case R.id.farhenheit:
                        fragment = new FahrenheitFragment();
                        break;
                    case R.id.search:
                        fragment = new SearchFragment();
                        break;
                }

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,fragment);
                transaction.commit();
                return true;
            }
        });

    }


}
