package com.sourcey.check_in;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.sourcey.check_in.Onboarding.Onboarding1;
import com.sourcey.check_in.R;

@SuppressLint("CustomSplashScreen")
public class Splashscreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private static String SHARED_NAME = "SPLASH";
    private static String FIRST_TIME = "FIRST_TIME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkFirstTime(this)) {
            setContentView(R.layout.splashscreen);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    startActivity(new Intent(Splashscreen.this, Onboarding1.class));
                    finish();
                }
            }, SPLASH_TIME_OUT);
        } else {
            startActivity(new Intent(Splashscreen.this, LoginActivity.class));
            finish();
        }
    }

    public static boolean checkFirstTime(Context ctx) {
        SharedPreferences settings = ctx.getSharedPreferences(SHARED_NAME, 0);
        Boolean first = settings.getBoolean(FIRST_TIME, false);
        if (!first) {
            settings = ctx.getSharedPreferences(SHARED_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean(FIRST_TIME, true);
            editor.commit();
        }
        return first;

    }

}

