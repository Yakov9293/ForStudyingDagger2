package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BoatFragment boatFragment = new BoatFragment();
    CarFragment carFragment = new CarFragment();
    RailwayFragment railwayFragment = new RailwayFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navSelectLitner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navSelectLitner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.nav_railway:
                    getSupportActionBar().show();
                    railwayFragment = (RailwayFragment) fragmentManager.findFragmentByTag("RAILWAY_FRAG");
                    if (railwayFragment != null) {
                        fragmentTransaction.replace(R.id.frame_content, railwayFragment);
                    } else {
                        fragmentTransaction.replace(R.id.frame_content, new RailwayFragment(), "RAILWAY_FRAG");
                    }
                    break;
                case R.id.nav_boat:
                    getSupportActionBar().hide();
                    boatFragment = (BoatFragment) fragmentManager.findFragmentByTag("BOAT_FRAG");
                    if (boatFragment != null) {
                        fragmentTransaction.replace(R.id.frame_content, railwayFragment);
                    } else {
                        fragmentTransaction.replace(R.id.frame_content, new BoatFragment(), "BOAT_FRAG");
                    }
                    break;
                case R.id.nav_car:
                    getSupportActionBar().hide();
                    carFragment = (CarFragment) fragmentManager.findFragmentByTag("CAR_FRAG");
                    if (carFragment != null) {
                        fragmentTransaction.replace(R.id.frame_content, carFragment);
                    } else {
                        fragmentTransaction.replace(R.id.frame_content, new CarFragment(), "CAR_FRAG");
                    }
                    break;
            }
            fragmentTransaction.commit();
            return true;
        }
    };
}