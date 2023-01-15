package com.turbo.app.turbovpnpro.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.turbo.app.turbovpnpro.Adapter.AppListAdapter;
import com.turbo.app.turbovpnpro.Adapter.CountryListAdapter;
import com.turbo.app.turbovpnpro.Models.CountryListModel;
import com.turbo.app.turbovpnpro.R;

import java.util.ArrayList;

public class SplitActivity extends AppCompatActivity {
    ArrayList<String> applist = new ArrayList<>();
    AppListAdapter appListAdapter;
    RecyclerView recyclr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclr = findViewById(R.id.recyclr);

        applist.add("Chrome");
        applist.add("Facebook");
        applist.add("Instagram");
        applist.add("Whatsapp");
        applist.add("Chrome");
        applist.add("Facebook");
        applist.add("Instagram");
        applist.add("Whatsapp");
        applist.add("Chrome");
        applist.add("Facebook");
        applist.add("Instagram");
        applist.add("Whatsapp");

        appListAdapter = new AppListAdapter(this, applist, new AppListAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(String server, int postion, boolean status) {

            }
        });

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
        recyclr.setLayoutManager(layoutManager);
        recyclr.setAdapter(appListAdapter);

    }
}