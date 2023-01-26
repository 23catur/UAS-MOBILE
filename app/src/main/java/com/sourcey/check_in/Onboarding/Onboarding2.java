package com.sourcey.check_in.Onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.sourcey.check_in.LoginActivity;
import com.sourcey.check_in.R;

public class Onboarding2 extends AppCompatActivity {

  //  private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.onboarding2);
 /*       new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(Onboarding2.this, Onboarding3.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
*/
        Button next = (Button) findViewById(R.id.BTN_NEXT02);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Onboarding2.this, Onboarding3.class));
                finish();            }
        });

        Button skip = (Button) findViewById(R.id.BTN_SKIP02);
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Onboarding2.this, LoginActivity.class));
                finish();            }
        });

    }
}

