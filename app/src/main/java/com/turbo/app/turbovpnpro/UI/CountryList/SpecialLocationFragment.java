package com.turbo.app.turbovpnpro.UI.CountryList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turbo.app.turbovpnpro.Adapter.CountryListAdapter;
import com.turbo.app.turbovpnpro.Models.CountryListModel;
import com.turbo.app.turbovpnpro.R;

import java.util.ArrayList;

public class SpecialLocationFragment extends Fragment {

    ArrayList<CountryListModel> countryList = new ArrayList<>();
    CountryListAdapter countryListAdapter;
    RecyclerView recyclr;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_special_location, container, false);


        recyclr = view.findViewById(R.id.recyclr);

        countryList.add(new CountryListModel(1, "United Estates", false));
        countryList.add(new CountryListModel(2, "Canada", false));
        countryList.add(new CountryListModel(3, "Australia", false));
        countryList.add(new CountryListModel(4, "America", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryListAdapter = new CountryListAdapter(requireActivity(), countryList, new CountryListAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(CountryListModel server, int postion, boolean favorite) {
                for (int i = 0; i < countryList.size(); i++) {
                    countryList.get(i).setSelected(false);
                }
                countryList.get(postion).setSelected(true);
                countryListAdapter.notifyDataSetChanged();
            }
        });

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireActivity(), 1, RecyclerView.VERTICAL, false);
        recyclr.setLayoutManager(layoutManager);
        recyclr.setAdapter(countryListAdapter);


        return view;
    }
}