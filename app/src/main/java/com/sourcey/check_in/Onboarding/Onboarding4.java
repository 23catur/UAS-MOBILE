package com.sourcey.check_in.Onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.sourcey.check_in.LoginActivity;
import com.sourcey.check_in.R;

public class Onboarding4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.onboarding4);
   /*         new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    startActivity(new Intent(Onboarding4.this, LoginActivity.class));
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }*/
        Button next = (Button) findViewById(R.id.BTN_NEXT04);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Onboarding4.this, LoginActivity.class));
                finish();
            }
        });

        Button skip = (Button) findViewById(R.id.BTN_SKIP04);
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Onboarding4.this, LoginActivity.class));
                finish();
            }
        });
    }
}




