package com.turbo.app.turbovpnpro.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turbo.app.turbovpnpro.R;
import com.turbo.app.turbovpnpro.UI.CountryList.CountryListActivity;
import com.turbo.app.turbovpnpro.UI.login.ForgetPasswordActivity;
import com.turbo.app.turbovpnpro.UI.login.LoginActivity;


public class ConnectionFragment extends Fragment {
View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_connection, container, false);

        view.findViewById(R.id.country_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), CountryListActivity.class));
            }
        });

        return view;
    }
}