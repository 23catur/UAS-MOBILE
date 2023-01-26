package com.sourcey.check_in.Onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.sourcey.check_in.R;

public class Onboarding1 extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private static String SHARED_NAME = "SPLASH";
    private static String FIRST_TIME = "FIRST_TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        {
            setContentView(R.layout.onboarding1);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    startActivity(new Intent(Onboarding1.this, Onboarding2.class));
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }

}
