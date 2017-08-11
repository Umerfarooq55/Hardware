package com.greentech.quran.hardware;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    Button enableButton;

    Button Bluethooth;
    private BluetoothAdapter BA;




    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);



        enableButton = (Button) findViewById(R.id.wifi);


        enableButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                    Intent i = new Intent(MainActivity.this,Wifistatus.class);
                    startActivity(i);

            }
        });
        Bluethooth=(Button)findViewById(R.id.bluethooth);

        Bluethooth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BA = BluetoothAdapter.getDefaultAdapter();
                if (!BA.isEnabled()) {
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, 0);
                    Toast.makeText(getApplicationContext(), "Bluetooth is Turn Off ",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "bluethooth is Working Properly", Toast.LENGTH_LONG).show();
                }

            }
        });
       Button Camera=(Button)findViewById(R.id.camera);

        Camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              Intent i = new Intent(MainActivity.this,CameraActivity.class);
                startActivity(i);


            }
        });
        Button telephony=(Button)findViewById(R.id.Telephony);

        telephony.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(isPermissionGranted()){
                    Intent i = new Intent(MainActivity.this,Telephony.class);
                    startActivity(i);

                }


            }
        });
        Button batery =(Button)findViewById(R.id.Battery);
        batery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,bettery.class);
                startActivity(i);
            }
        });
        Button multitouch =(Button)findViewById(R.id.multitouch);
        multitouch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Multitouch.class);
                startActivity(i);
            }
        });
        Button systeminfo =(Button)findViewById(R.id.systeminfo);
        systeminfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Systeminfo.class);
                startActivity(i);
            }
        });
        Button senserinfo =(Button)findViewById(R.id.sensers);
        senserinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,sensers.class);
                startActivity(i);
            }
        });
        Button gps =(Button)findViewById(R.id.gps);
        gps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AndroidGPSTrackingActivity.class);
                startActivity(i);
            }
        });

        Button cpu =(Button)findViewById(R.id.cpu);
        cpu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,cpu.class);
                startActivity(i);
            }
        });
        Button myapp =(Button)findViewById(R.id.apps);
        myapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Myapplication.class);
                startActivity(i);
            }
        });

    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_PHONE_STATE}, 2);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 2: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    //do ur specific task after read phone state granted
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}





