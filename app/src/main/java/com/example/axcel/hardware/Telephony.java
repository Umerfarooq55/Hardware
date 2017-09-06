package com.example.axcel.hardware;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.ads.InterstitialAd;

public class Telephony extends AppCompatActivity {
    TelephonyManager mTelephonyMgr;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = mTelephonyMgr.getDeviceId();
        TextView timei = (TextView) findViewById(R.id.imei);
        timei.setText(imei);

        String oppcode = mTelephonyMgr.getNetworkOperator();
        TextView toppcode = (TextView) findViewById(R.id.oppcode);
        toppcode.setText(oppcode);

        String oppname = mTelephonyMgr.getNetworkOperatorName();
        TextView toppname = (TextView) findViewById(R.id.oppname);
        toppname.setText(oppname);

        String serialnumber = mTelephonyMgr.getSimSerialNumber();
        TextView tserialnumber = (TextView) findViewById(R.id.serialnumber);
        tserialnumber.setText(serialnumber);

        String ssubid = mTelephonyMgr.getSubscriberId();
        TextView tsubid = (TextView) findViewById(R.id.subid);
        tsubid.setText(ssubid);

        String ciso = mTelephonyMgr.getSimCountryIso();
        TextView ctiso = (TextView) findViewById(R.id.ciso);
        ctiso.setText(ciso);


//        CellLocation celllocation = mTelephonyMgr.getCellLocation();
//        TextView tcell = (TextView) findViewById(R.id.cell);
//        String cell = celllocation.toString();
//        tcell.setText(cell);

        int ncelllocation = mTelephonyMgr.getNetworkType();
        TextView ntcell = (TextView) findViewById(R.id.nnetworktype);
        String ncell = String.valueOf(ncelllocation);
        ntcell.setText(ncell);

        boolean bromaing = mTelephonyMgr.isNetworkRoaming();
        TextView tromaing = (TextView) findViewById(R.id.roaming);
        String sroaming = String.valueOf(bromaing);
        tromaing.setText(sroaming);

        String line1Number = mTelephonyMgr.getLine1Number();
        TextView tline = (TextView) findViewById(R.id.line);
        tline.setText(line1Number);

//        mInterstitialAd = new InterstitialAd(this);
//
//        // set the ad unit ID
//        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
//
//        AdRequest adRequest = new AdRequest.Builder()
//                .build();
//
//        // Load ads into Interstitial Ads
//        mInterstitialAd.loadAd(adRequest);
//
//        mInterstitialAd.setAdListener(new AdListener() {
//            public void onAdLoaded() {
//                showInterstitial();
//            }
//        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
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



}





