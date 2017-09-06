package com.example.axcel.hardware;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class PercentageLoading extends AppCompatActivity {
    ImageView circle;
    ImageView mid_circle;
    int angle = 10;
    int midangle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage_loading);
        circle = (ImageView) findViewById(R.id.circle);
        mid_circle = (ImageView) findViewById(R.id.mid_circle);
        MyRotation();
        MymidRotation();
    }

    public void MyRotation() {
        angle = angle + 10;
        circle.setRotation(angle);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                MyRotation();
                // close this activity

            }
        }, 250);


    }

    public void MymidRotation() {
        midangle = midangle - 10;
        mid_circle.setRotation(midangle);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                MymidRotation();
                // close this activity

            }
        }, 250);


    }
}
