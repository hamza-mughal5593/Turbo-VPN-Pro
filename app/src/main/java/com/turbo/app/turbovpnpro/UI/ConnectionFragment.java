package com.turbo.app.turbovpnpro.UI;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

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
        view.findViewById(R.id.select_fastest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), CountryListActivity.class));
            }
        });
        needLogin();
        return view;
    }
    private void needLogin() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.permission_alert);

        final TextView done_btn = (TextView) dialog.findViewById(R.id.done_btn);




        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        if (!((requireActivity()).isFinishing())) {
            dialog.show();
        }


    }

}