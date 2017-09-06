package com.example.axcel.hardware;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AndroidGPSTrackingActivity extends AppCompatActivity {
	
	Button btnShowLocation;
	
	// GPSTracker class
	GPSTracker gps;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        
        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {		
				// create class object
		        gps = new GPSTracker(AndroidGPSTrackingActivity.this);

				// check if GPS enabled		
		        if(gps.canGetLocation()){
		        	
		        	double latitude = gps.getLatitude();
		        	double longitude = gps.getLongitude();

					TextView tlatitude = (TextView) findViewById(R.id.latitude);
					String slatitude = String.valueOf(latitude);
					tlatitude.setText(slatitude);

					TextView tlagitude = (TextView) findViewById(R.id.lag);
					String slag = String.valueOf(longitude);
					tlagitude.setText(slag);
		        	// \n is for new line

		        }else{
		        	// can't get location
		        	// GPS or Network is not enabled
		        	// Ask user to enable GPS/network in settings
		        	gps.showSettingsAlert();
		        }
				
			}
		});
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