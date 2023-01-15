package com.turbo.app.turbovpnpro.UI.Feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.turbo.app.turbovpnpro.R;
import com.turbo.app.turbovpnpro.UI.HomeActivity;

public class FeedbackMainActivity extends AppCompatActivity {
RelativeLayout connection_btn;
RelativeLayout slow_speed_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_main);

        connection_btn=  findViewById(R.id.connection_btn);
        slow_speed_btn=  findViewById(R.id.slow_speed_btn);

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        connection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FeedbackMainActivity.this, FeedbackActivity.class));
            }
        });
        slow_speed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FeedbackMainActivity.this, FeedbackActivity.class));
            }
        });

    }
}