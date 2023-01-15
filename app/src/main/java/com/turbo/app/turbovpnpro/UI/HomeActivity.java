package com.turbo.app.turbovpnpro.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.turbo.app.turbovpnpro.R;
import com.turbo.app.turbovpnpro.SpeedTestActivity;
import com.turbo.app.turbovpnpro.UI.FaQ.FaqActivity;
import com.turbo.app.turbovpnpro.UI.Feedback.FeedbackMainActivity;
import com.turbo.app.turbovpnpro.UI.login.LoginActivity;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navView;
    DrawerLayout drawerLayout;
    NavigationView side_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawerLayout);
        side_nav = findViewById(R.id.side_nav);

        findViewById(R.id.menu_btn).setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
        side_nav.setNavigationItemSelectedListener(this);


        View headerview = side_nav.getHeaderView(0);
        RelativeLayout profilename = (RelativeLayout) headerview.findViewById(R.id.sign_in_btn);
        profilename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));

            }
        });
findViewById(R.id.spit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SplitActivity.class));

            }
        });



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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_feedback) {
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(new Intent(HomeActivity.this, FeedbackMainActivity.class));
        } else if (item.getItemId() == R.id.nav_setting) {
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(new Intent(HomeActivity.this, SettingActivity.class));
        } else if (item.getItemId() == R.id.nav_faq) {
            startActivity(new Intent(HomeActivity.this, FaqActivity.class));
            drawerLayout.closeDrawer(GravityCompat.START);
        }
//        else if (item.getItemId() == R.id.nav_privacy_policy) {
//            privacyPolicy(this);
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else if (item.getItemId() == R.id.nav_exit) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//            onBackPressed();
//        }
        return true;
    }
}