package com.greentech.quran.hardware;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

import java.util.Calendar;

public class Autotest extends AppCompatActivity {
    private AnimatedCircleLoadingView animatedCircleLoadingView;
    ScrollView myscroll;
    Calendar calander;
    CameraManager mCameraManager;
    String mCameraId;
    SimpleDateFormat simpledateformat;
    String Date;
    Camera cam;
    TextView DisplayDateTime;
    ImageView bluetooth, wifi, backCamera, FrontCamera, telephont, multitouch, sensors, batery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autotest);

        animatedCircleLoadingView = (AnimatedCircleLoadingView) findViewById(R.id.circle_loading_view);
        final Button autostart = (Button) findViewById(R.id.auto_start);
        final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        linear.setVisibility(View.VISIBLE);
        final LinearLayout lineartesting = (LinearLayout) findViewById(R.id.lneartesting);
        lineartesting.setVisibility(View.GONE);
        final RelativeLayout frame = (RelativeLayout) findViewById(R.id.frame);
        frame.setVisibility(View.GONE);
        final TextView testcom = (TextView) findViewById(R.id.test_in_progress);
        testcom.setVisibility(View.GONE);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.beep);
        final TextView datetime = (TextView) findViewById(R.id.datetime);
        int houri = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minutei = Calendar.getInstance().get(Calendar.MINUTE);
        int datedatei = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int datemonthi = Calendar.getInstance().get(Calendar.MONTH);
        int yeari = Calendar.getInstance().get(Calendar.YEAR);
        String hour = String.valueOf(houri);
        String minute = String.valueOf(minutei);
        String date = String.valueOf(datedatei);
        String datemonth = String.valueOf(datemonthi);
        String year = String.valueOf(yeari);

// textView is the TextView view that should display it
        datetime.setText("Date: " + datemonthi + "/" + date + "/" + year + "  " + "Time: " + hour + ":" + minute);


        autostart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        frame.setVisibility(View.GONE);
                        lineartesting.setVisibility(View.VISIBLE);
                        autostart.setVisibility(View.GONE);
                        linear.setVisibility(View.VISIBLE);
                        testcom.setVisibility(View.GONE);


                        // close this activity

                    }
                }, 13000);

                startLoading();
                startPercentMockThread();
                frame.setVisibility(View.VISIBLE);
                linear.setVisibility(View.GONE);
                autostart.setVisibility(View.INVISIBLE);
                testcom.setVisibility(View.VISIBLE);


                datetime.setVisibility(View.INVISIBLE);


                mediaPlayer.start();
                ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(1000);
                mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                try {
                    mCameraId = mCameraManager.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                turnOnFlashLight();


//                 bluetooth = (ImageView) findViewById(R.id.btest);
//                bluetooth.setImageResource(R.drawable.ic_check_black_24dp);
//
//                wifi = (ImageView) findViewById(R.id.wifi_test);
//                wifi.setImageResource(R.drawable.ic_check_black_24dp);
//
//                 batery= (ImageView) findViewById(R.id.battery_test);
//                batery.setImageResource(R.drawable.ic_battery_charging_full_black_24dp);
//
//                multitouch = (ImageView) findViewById(R.id.multitouch_test);
//                multitouch.setImageResource(R.drawable.multi_touch);
//                bluetooth = (ImageView) findViewById(R.id.btest);
//                bluetooth.setImageResource(R.drawable.blue_tooth);
//                bluetooth = (ImageView) findViewById(R.id.btest);
//                bluetooth.setImageResource(R.drawable.blue_tooth);
//                bluetooth = (ImageView) findViewById(R.id.btest);
//                bluetooth.setImageResource(R.drawable.blue_tooth);
//                bluetooth = (ImageView) findViewById(R.id.btest);
//                bluetooth.setImageResource(R.drawable.blue_tooth);
//                bluetooth = (ImageView) findViewById(R.id.btest);
//                bluetooth.setImageResource(R.drawable.blue_tooth);

            }
        });

    }

    private void startLoading() {
        animatedCircleLoadingView.startDeterminate();
    }

    private void startPercentMockThread() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(65);
                        changePercent(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }

    private void changePercent(final int percent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                animatedCircleLoadingView.setPercent(percent);
            }
        });
    }

    public void resetLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                animatedCircleLoadingView.resetLoading();
            }
        });
    }
    public void turnOnFlashLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, true);
                turnOffFlashLight();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void turnOffFlashLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, false);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}