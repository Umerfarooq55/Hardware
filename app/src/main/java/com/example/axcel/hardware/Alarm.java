package com.example.axcel.hardware;

/**
 * Created by Umerfarooq on 8/31/2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by uplsafetychamp on 5/15/2017.
 */

public class Alarm extends BroadcastReceiver {
    NotificationCompat notification;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub


        // here you can start an activity or service depending on your need
        // for ex you can start an activity to vibrate phone or to ring the phone

        String phoneNumberReciver = "03330481320";// phone number to which SMS to be send
        String message = "Hi I will be there later, See You soon";// message to send
        // SmsManager sms = SmsManager.getDefault();
        // sms.sendTextMessage(phoneNumberReciver, null, message, null, null);
        // Show the toast  like in above screen shot
        Toast.makeText(context, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();
        Intent i = new Intent();
        i.setClassName("com.greentech.quran.hardware", "com.greentech.quran.hardware.Home_Screen");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(i);

    }


}