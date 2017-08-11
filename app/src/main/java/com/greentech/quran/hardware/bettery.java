package com.greentech.quran.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class bettery extends AppCompatActivity {

    int health;

    int icon_small;

    int level;

    int plugged;

    boolean present;

    int scale;

    int status;

    String technology;

    int temperature;

    int voltage;

    TextView text;

    ProgressBar pb;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bettery);

        registerReceiver(mBatInfoReceiver, new IntentFilter(

                Intent.ACTION_BATTERY_CHANGED));

        text = (TextView) findViewById(R.id.text);

        pb = (ProgressBar) findViewById(R.id.progressBar);



    }



    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {

        @Override

        public void onReceive(Context c, Intent intent) {



            level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

            health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);

            icon_small = intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, 0);

            plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);

            present = intent.getExtras().getBoolean(

                    BatteryManager.EXTRA_PRESENT);

            scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);

            status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);

            technology = intent.getExtras().getString(

                    BatteryManager.EXTRA_TECHNOLOGY);

            temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,

                    0);

            voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);



            pb.setProgress(level);





            text.setText("Level                  " + level + "\n\n" + "Health                " + health + "\n\n"

                    + "Icon Small         " + icon_small + "\n\n" +



                    "Plugged              " + plugged + "\n\n" + "Present:             " + present + "\n\n"

                    + "Scale                  " + scale + "\n\n" + "Status                " + status + "\n\n"

                    + "Technology     " + technology + "\n\n" + "Temperature           "

                    + temperature + "\n\n" + "Voltage               " + voltage + "\n\n");

//            TextView tlevel = (TextView) findViewById(R.id.level);
//            tlevel.setText(level);
//            TextView thealth = (TextView) findViewById(R.id.health);
//            thealth.setText(health);
//
//            TextView tplugged = (TextView) findViewById(R.id.pluggesd);
//            tplugged.setText(plugged);
////
////            TextView tpresent = (TextView) findViewById(R.id.present);
////            String spresent = String.valueOf(present);
////            tpresent.setText(spresent );
////
//
//            TextView tscale = (TextView) findViewById(R.id.scale);
//            tscale.setText(scale);
//
//
//            TextView tstatus = (TextView) findViewById(R.id.status);
//            tstatus.setText(status);
//
//            TextView ttech = (TextView) findViewById(R.id.technolgy);
//            ttech.setText(technology);
//
//            TextView ttemp = (TextView) findViewById(R.id.temprature);
//            ttemp.setText(temperature);
//
//            TextView tvol = (TextView) findViewById(R.id.voltage);
//            tvol.setText( voltage);




        }

    };

}