package com.sourcey.check_in.Onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.sourcey.check_in.LoginActivity;
import com.sourcey.check_in.R;

public class Onboarding3 extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private static String SHARED_NAME = "SPLASH";
    private static String FIRST_TIME = "FIRST_TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            setContentView(R.layout.onboarding3);
  /*          new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    startActivity(new Intent(Onboarding3.this, Onboarding4.class));
                    finish();
                }
            }, SPLASH_TIME_OUT);
*/
        Button next = (Button) findViewById(R.id.BTN_NEXT03);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Onboarding3.this, Onboarding4.class));
                finish();            }
        });

        Button skip = (Button) findViewById(R.id.BTN_SKIP03);
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Onboarding3.this, LoginActivity.class));
                finish();            }
        });

    }
}
