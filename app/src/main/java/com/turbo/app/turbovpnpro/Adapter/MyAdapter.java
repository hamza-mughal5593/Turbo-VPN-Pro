package com.turbo.app.turbovpnpro.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.turbo.app.turbovpnpro.UI.CountryList.LocationFragment;
import com.turbo.app.turbovpnpro.UI.CountryList.SpecialLocationFragment;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LocationFragment homeFragment = new LocationFragment();
                return homeFragment;
            case 1:
                SpecialLocationFragment sportFragment = new SpecialLocationFragment();
                return sportFragment;

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}