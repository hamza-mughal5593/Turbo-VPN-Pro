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
import com.turbo.app.turbovpnpro.Models.ExpandableListDataItems;
import com.turbo.app.turbovpnpro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LocationFragment extends Fragment  implements ChildClick, HeaderClick {
View view;
    ExpandableListView expandableListViewExample;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableTitleList;
    HashMap<String, List<String>> expandableDetailList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_location, container, false);




        expandableListViewExample = (ExpandableListView) view.findViewById(R.id.expandableListView);
        expandableDetailList = ExpandableListDataItems.getData();
        expandableTitleList = new ArrayList<String>(expandableDetailList.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(getActivity(), expandableTitleList, expandableDetailList);
        expandableListViewExample.setAdapter(expandableListAdapter);

        // This method is called when the group is expanded
        expandableListViewExample.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(), expandableTitleList.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        // This method is called when the group is collapsed
        expandableListViewExample.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(requireActivity(), expandableTitleList.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
            }
        });

        // This method is called when the child in any group is clicked
        // via a toast method, it is shown to display the selected child item as a sample
        // we may need to add further steps according to the requirements
        expandableListViewExample.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(requireActivity(), expandableTitleList.get(groupPosition)
                        + " -> "
                        + expandableDetailList.get(
                        expandableTitleList.get(groupPosition)).get(
                        childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
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