package com.turbo.app.turbovpnpro.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.turbo.app.turbovpnpro.R;
import com.turbo.app.turbovpnpro.SpeedTestActivity;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         navView = findViewById(R.id.nav_view);
        loadFragment(new ConnectionFragment());
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        loadFragment(new ConnectionFragment());
                        return true;
                    case R.id.navigation_speed:
                        startActivity(new Intent(HomeActivity.this, SpeedTestActivity.class));
                        return true;
                    case R.id.navigation_setting:
                        startActivity(new Intent(HomeActivity.this, SettingActivity.class));
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        navView.getMenu().findItem(R.id.navigation_home).setChecked(true);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_frame, fragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }

}