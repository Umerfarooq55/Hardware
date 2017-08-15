package com.greentech.quran.hardware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Autotest extends AppCompatActivity {
         ImageView bluetooth , wifi , backCamera , FrontCamera , telephont , multitouch, sensors , batery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autotest);
        Button autostart =(Button)findViewById(R.id.auto_start);
        autostart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
}
