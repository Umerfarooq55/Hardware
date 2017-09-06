package com.example.axcel.hardware;

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
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
    ScrollView myscroll;
    Calendar calander;
    CameraManager mCameraManager;
    String mCameraId;
    SimpleDateFormat simpledateformat;
    String Date;
    Camera cam;
    TextView DisplayDateTime;
    ImageView bluetooth, wifi, backCamera, FrontCamera, telephont, multitouch, sensors, batery , gps_test;
    ImageView circle;
    ImageView mid_circle;
    int angle = 10;
    int midangle = 0;
    int count = 0;
    TextView loding;
    ImageView grid;
    private AnimatedCircleLoadingView animatedCircleLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autotest);
        loding = (TextView) findViewById(R.id.percentage);
        loding.setVisibility(View.GONE);

        grid = (ImageView) findViewById(R.id.grid);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        circle = (ImageView) findViewById(R.id.circle);
        mid_circle = (ImageView) findViewById(R.id.mid_circle);
        bluetooth = (ImageView) findViewById(R.id.btest);
        wifi = (ImageView) findViewById(R.id.wifi_test);
        backCamera = (ImageView) findViewById(R.id.back_camera_test);
        FrontCamera = (ImageView) findViewById(R.id.front_camera_test);
        telephont = (ImageView) findViewById(R.id.telephony_test);
        multitouch = (ImageView) findViewById(R.id.multitouch_test);
        sensors = (ImageView) findViewById(R.id.sensors_test);
        batery = (ImageView) findViewById(R.id.attery_test);
        gps_test = (ImageView) findViewById(R.id.gps_test);
        bluetooth.setVisibility(View.GONE);
        wifi.setVisibility(View.GONE);
        backCamera.setVisibility(View.GONE);
        FrontCamera.setVisibility(View.GONE);
        telephont.setVisibility(View.GONE);
        multitouch.setVisibility(View.GONE);
        sensors.setVisibility(View.GONE);
        batery.setVisibility(View.GONE);
        gps_test.setVisibility(View.GONE);
        circle.setVisibility(View.GONE);
        mid_circle.setVisibility(View.GONE);
        loding = (TextView) findViewById(R.id.percentage);
        loding.setText(count + "");


        circle.setVisibility(View.GONE);
        mid_circle.setVisibility(View.GONE);


        bluetooth.setVisibility(View.GONE);
        wifi.setVisibility(View.GONE);
        backCamera.setVisibility(View.GONE);
        FrontCamera.setVisibility(View.GONE);
        telephont.setVisibility(View.GONE);
        multitouch.setVisibility(View.GONE);
        sensors.setVisibility(View.GONE);
        batery.setVisibility(View.GONE);
        gps_test.setVisibility(View.GONE);



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
        linear.setVisibility(View.GONE);
// textView is the TextView view that should display it
        datetime.setText("Last Test On: " + datemonthi + "/" + date + "/" + year + "  " + "Time: " + hour + ":" + minute);


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
                        circle.setVisibility(View.GONE);
                        mid_circle.setVisibility(View.GONE);
                        loding.setVisibility(View.GONE);
                        // close this activity
                        grid.setVisibility(View.GONE);

                    }
                }, 13000);
                grid = (ImageView) findViewById(R.id.grid);
                grid.setVisibility(View.GONE);
                loding.setVisibility(View.VISIBLE);
                circle.setVisibility(View.VISIBLE);
                mid_circle.setVisibility(View.VISIBLE);


                MyRotation();
                MymidRotation();
                frame.setVisibility(View.VISIBLE);
                linear.setVisibility(View.GONE);
                autostart.setVisibility(View.GONE);
                testcom.setVisibility(View.VISIBLE);


                datetime.setVisibility(View.GONE);

                bluetooth.setVisibility(View.VISIBLE);
                wifi.setVisibility(View.VISIBLE);
                backCamera.setVisibility(View.VISIBLE);
                FrontCamera.setVisibility(View.VISIBLE);
                telephont.setVisibility(View.VISIBLE);
                multitouch.setVisibility(View.VISIBLE);
                sensors.setVisibility(View.VISIBLE);
                batery.setVisibility(View.VISIBLE);
                gps_test.setVisibility(View.VISIBLE);


                mediaPlayer.start();
                ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(1000);
                mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                try {
                    mCameraId = mCameraManager.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                turnOnFlashLight();




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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        if (count < 100) {
            count = count + 2;

        }

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
                loding.setText(count + " %");
                MymidRotation();
                // close this activity

            }
        }, 250);


    }
}