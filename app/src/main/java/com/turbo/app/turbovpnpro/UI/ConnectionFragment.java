package com.turbo.app.turbovpnpro.UI;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.turbo.app.turbovpnpro.R;
import com.turbo.app.turbovpnpro.UI.CountryList.CountryListActivity;
import com.turbo.app.turbovpnpro.UI.login.ForgetPasswordActivity;
import com.turbo.app.turbovpnpro.UI.login.LoginActivity;

import java.util.Timer;


public class ConnectionFragment extends Fragment {
View view;
String status= "dis";
LottieAnimationView animationView;
TextView status_text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_connection, container, false);

        animationView = view.findViewById(R.id.animationView);
        status_text = view.findViewById(R.id.status_text);

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
//        conn_dialog();


        if (status.equals("dis")){
            animationView.setAnimation(R.raw.connect);
            animationView.playAnimation();
            status_text.setText("Disconnected");
            status_text.setTextColor(getResources().getColor(R.color.red));
        }
        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status.equals("dis")){

                    conn_dialog();






                }else {
                    disconnect_dialog();

                }

            }
        });


        return view;
    }
    private void conn_dialog() {

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
                animationView.setAnimation(R.raw.connecting);
                animationView.playAnimation();
                status = "connecting";
                status_text.setText("Connecting");
                status_text.setTextColor(getResources().getColor(R.color.blue));
                new CountDownTimer(3000, 1000) {
                    public void onTick(long millisUntilFinished) {

                    }

                    public void onFinish() {
                        animationView.setAnimation(R.raw.connected);
                        animationView.playAnimation();
                        status = "con";

                        status_text.setText("Connected");
                        status_text.setTextColor(getResources().getColor(R.color.green));
                    }
                }.start();
            }
        });
        if (!((requireActivity()).isFinishing())) {
            dialog.show();
        }


    }
    private void disconnect_dialog() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.disconnect_dialog);

        final TextView cancel_button = (TextView) dialog.findViewById(R.id.cancel_button);
        final TextView disconnect_btn = (TextView) dialog.findViewById(R.id.disconnect_btn);




        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        disconnect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                status="dis";
                animationView.setAnimation(R.raw.connect);
                animationView.playAnimation();
                status_text.setText("Disconnected");
                status_text.setTextColor(getResources().getColor(R.color.red));
            }
        });


        if (!((requireActivity()).isFinishing())) {
            dialog.show();
        }


    }
}