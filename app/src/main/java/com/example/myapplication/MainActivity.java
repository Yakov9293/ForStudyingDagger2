package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navSelectLitner);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navSelectLitner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId())
            {
                case R.id.nav_railway:

                    selectedFragment = new RailwayFragment();
                    break;
                case R.id.nav_boat:
                    //getSupportActionBar().hide();
                    selectedFragment = new BoatFragment();
                    break;
                case R.id.nav_car:
                    //getSupportActionBar().hide();
                    selectedFragment = new CarFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, selectedFragment).commit();
            return true;
        }
    };
}