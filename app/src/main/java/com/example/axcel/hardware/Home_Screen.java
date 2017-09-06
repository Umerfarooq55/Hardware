package com.example.axcel.hardware;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Home_Screen extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ImageView circle;
    ImageView mid_circle;
    int angle = 10;
    int midangle = 0;
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);

        circle = (ImageView) findViewById(R.id.circle);
        mid_circle = (ImageView) findViewById(R.id.mid_circle);
        circle.setRotation(20);
        MyRotation();
        MymidRotation();




        bottomNavigation = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.bottom_menu);
        fragmentManager = getSupportFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.star:
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/developer?id=Axcel%20Studio&hl=en"));
                        startActivity(intent);
                        break;
                    case R.id.more:
                        Intent intent1 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/developer?id=Axcel%20Studio&hl=en"));
                        startActivity(intent1);
                        break;
                    case R.id.share:
                        // //
                        try {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                            String sAux = "\nDownload Hardware Doctor Aoo\n\n";
                            sAux = sAux + "https://play.google.com/store/apps/developer?id=Axcel%20Studio&hl=en \n\n";
                            i.putExtra(Intent.EXTRA_TEXT, sAux);
                            startActivity(Intent.createChooser(i, "choose one"));
                        } catch (Exception e) {
                            //e.toString();
                        }

                        break;
                }
//                final FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
        ImageView test_manually = (ImageView) findViewById(R.id.manually_icon);
        test_manually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_Screen.this, MainActivity.class);
                startActivity(i);

            }
        });
        ImageView test_auto = (ImageView) findViewById(R.id.test_auto);
        test_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_Screen.this, Autotest.class);
                startActivity(i);

            }
        });
        ImageView scedule = (ImageView) findViewById(R.id.scdule);
        scedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // i.e. 24*60*60*1000= 86,400,000   milliseconds in a day
//                Long time = new GregorianCalendar().getTimeInMillis()+60000;
//
//
//                Intent intentAlarm = new Intent(Home_Screen.this, Alarm.class);
//
//
//                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//
//                alarmManager.set(AlarmManager.RTC_WAKEUP,time, PendingIntent.getBroadcast(Home_Screen.this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
//                Toast.makeText(Home_Screen.this, "Alarm Scheduled for Tommrrow", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Home_Screen.this, EditDialogue.class);
                startActivity(i);
            }
        });
        ImageView quick = (ImageView) findViewById(R.id.about);
        quick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_Screen.this, About.class);
                startActivity(i);

            }
        });
        ImageView mid = (ImageView) findViewById(R.id.mid_circle);
        mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_Screen.this, QuickActivity.class);
                startActivity(i);

            }
        });
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
    public void onBackPressed() {

        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
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

}