package com.greentech.quran.hardware;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class sensers extends AppCompatActivity {

        ListView listView ;
        SensorManager sensorManager ;
        List<Sensor> listsensor;
        List<String> liststring ;
        ArrayAdapter<String> adapter ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sensers);
            Button accelerometer =(Button)findViewById(R.id.acceleometer);
            accelerometer .setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(sensers.this,Accelerometer.class);
                    startActivity(i);
                }
            });

            Button proximity =(Button)findViewById(R.id.proximity);
            proximity.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(sensers.this,proximity.class);
                    startActivity(i);
                }
            });

            listView = (ListView)findViewById(R.id.listview1);

            liststring = new ArrayList<String>();

            sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

            listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

            for(int i=0; i<listsensor.size(); i++){

                liststring.add(listsensor.get(i).getName());
            }

            adapter = new ArrayAdapter<String>(sensers.this,
                    android.R.layout.simple_list_item_2,
                    android.R.id.text1, liststring
            );

            listView.setAdapter(adapter);

        }
    }
