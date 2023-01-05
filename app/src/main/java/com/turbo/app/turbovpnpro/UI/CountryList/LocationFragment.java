package com.turbo.app.turbovpnpro.UI.CountryList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.turbo.app.turbovpnpro.Adapter.CustomExpandableListAdapter;
import com.turbo.app.turbovpnpro.Interface.ChildClick;
import com.turbo.app.turbovpnpro.Interface.HeaderClick;
import com.turbo.app.turbovpnpro.Models.CountryChildModel;
import com.turbo.app.turbovpnpro.Models.CountryParentModel;
import com.turbo.app.turbovpnpro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LocationFragment extends Fragment  implements ChildClick, HeaderClick {
View view;
    ExpandableListView expandableListView;

    ExpandableListAdapter expandableListAdapter;
    ArrayList<CountryParentModel> expandableListTitle;
    HashMap<String, List<CountryChildModel>> expandableListDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_location, container, false);




        expandableListView =   view.findViewById(R.id.expandableListView);
        expandableListTitle = new ArrayList<>();
        expandableListTitle.add(new CountryParentModel("Name","2 cities"));
        expandableListTitle.add(new CountryParentModel("Name","2 cities"));
        expandableListTitle.add(new CountryParentModel("Name","2 cities"));


        HashMap<String, List<CountryChildModel>> expandableListDetail = new HashMap<String, List<CountryChildModel>>();



        List<CountryChildModel> appCahe = new ArrayList<CountryChildModel>();
        List<CountryChildModel> systemCache = new ArrayList<>();
        List<CountryChildModel> obsoleteApk = new ArrayList<>();

        appCahe.add(new CountryChildModel("City name",false));
        appCahe.add(new CountryChildModel("City name",false));
        appCahe.add(new CountryChildModel("City name",false));

        systemCache.add(new CountryChildModel("City name",false));
        systemCache.add(new CountryChildModel("City name",false));
        systemCache.add(new CountryChildModel("City name",false));

        obsoleteApk.add(new CountryChildModel("City name",false));
        obsoleteApk.add(new CountryChildModel("City name",false));
        obsoleteApk.add(new CountryChildModel("City name",false));

        expandableListDetail.put("System Cache", systemCache);
        expandableListDetail.put("App Cache", appCahe);
        expandableListDetail.put("Obsolete Apk", obsoleteApk);




        expandableListAdapter = new CustomExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail, this, this);


        expandableListView.setAdapter(expandableListAdapter);
//        expandableListView.expandGroup(0);


        return view;
    }

    @Override
    public void UserClick(CountryChildModel expandedListText) {

    }

    @Override
    public void UserHeaderClick(String list) {
        Toast.makeText(getActivity(), ""+list, Toast.LENGTH_SHORT).show();
//        if (list.equalsIgnoreCase("System Cache")) {
//
//            for (int i = 0; i < res.size(); i++) {
//                if (res.get(i).isChecked()) {
////                       Paper.book().write("isChecked",false);
//                } else {
////                        Paper.book().write("isChecked",true);
//                }
//            }
//        }
//        if (list.equalsIgnoreCase("App Cache")) {
//            Toast.makeText(JunkActivity.this, "" + list, Toast.LENGTH_SHORT).show();
//        }
//        if (list.equalsIgnoreCase("Obsolete Apk")) {
//            Toast.makeText(JunkActivity.this, "" + list, Toast.LENGTH_SHORT).show();
//        }
    }
}