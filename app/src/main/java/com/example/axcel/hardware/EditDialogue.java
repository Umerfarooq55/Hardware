package com.example.axcel.hardware;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class EditDialogue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dialogue);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics());
        WindowManager.LayoutParams params = getWindow().getAttributes();

        params.x = -20;
        params.height = height;
        params.width = width;
        params.y = -10;
//
        this.getWindow().setAttributes(params);
        Button submit = (Button) findViewById(R.id.submit);
        Button close = (Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditDialogue.this, Home_Screen.class);
                startActivity(i);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText day = (EditText) findViewById(R.id.enterday);
                String value = day.getText().toString();


                if (value.equals("") || value.equals("0")) {

                    Toast.makeText(EditDialogue.this, "Please Input in Days", Toast.LENGTH_LONG).show();
                } else {
                    int finalValue = Integer.parseInt(value);
                    int daytime = 3600000 * finalValue;
                    Long time = new GregorianCalendar().getTimeInMillis() + daytime;

                    Intent intentAlarm = new Intent(EditDialogue.this, Alarm.class);


                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


                    alarmManager.set(AlarmManager.RTC_WAKEUP, time, PendingIntent.getBroadcast(EditDialogue.this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
                    Toast.makeText(EditDialogue.this, "Test Scheduled for " + value + " Hours", Toast.LENGTH_LONG).show();
                    Intent s = new Intent(EditDialogue.this, Home_Screen.class);
                    startActivity(s);

                }


            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //    finish();

    }

}
