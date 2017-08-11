package com.greentech.quran.hardware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class Wifistatus extends AppCompatActivity {
String mbps = "Mbps";
    String ghz = "Ghz";
    String dbm = "dBm";
    private String TAG = Wifistatus.class.getSimpleName();
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifistatus);
        Button enableButtontwo = (Button) findViewById(R.id.wifi_two);
//        disableButton=(Button)findViewById(R.id.button2);

        enableButtontwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                @SuppressLint("WifiManagerLeak") WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                if (wifi.setWifiEnabled(true)) {
                    Toast.makeText(Wifistatus.this, "Your wifi is working properly", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Wifistatus.this,Wifistatus.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Wifistatus.this, "wifi is not working properly", Toast.LENGTH_LONG).show();
                }
            }
        });



        @SuppressLint("WifiManagerLeak") WifiManager wifiManager = (WifiManager) getSystemService (Context.WIFI_SERVICE);

        WifiInfo connectionInfo = wifiManager.getConnectionInfo ();
        String ssid  = connectionInfo.getSSID();
        TextView wifissid = (TextView) findViewById(R.id.wifissid);
        wifissid.setText(ssid);

        String bssid = connectionInfo.getBSSID();
        TextView tbssid = (TextView) findViewById(R.id.wifibssid);
        tbssid.setText(bssid);

        int ipAddress = connectionInfo.getIpAddress();
        TextView tipadress = (TextView) findViewById(R.id.ipadress);
        String sipadress = Formatter.formatIpAddress(ipAddress);
        tipadress.setText(sipadress);


        int linkspeed =connectionInfo.getLinkSpeed();
        TextView tlinkspeed = (TextView) findViewById(R.id.linkspeed);
        String slinkspeed = String.valueOf(linkspeed);
        tlinkspeed.setText(slinkspeed + " " + mbps);

        float frecuency =connectionInfo.getFrequency();
        float ghzfrecuency = frecuency/1000;
        TextView tfrecuency = (TextView) findViewById(R.id.frecuency);
        String sfrecuency = String.valueOf(ghzfrecuency);
        tfrecuency.setText(sfrecuency + " " + ghz);

        int signal =connectionInfo.getRssi();
        TextView tSignal = (TextView) findViewById(R.id.signal);
        String sSignal = String.valueOf(signal);
        tSignal.setText(sSignal + " " + dbm);

        int networdid =connectionInfo.getNetworkId();
        TextView tnetworkid = (TextView) findViewById(R.id.networdid);
        String snetworkworkid =String.valueOf(networdid);
        tnetworkid.setText(snetworkworkid);


        String macAdress = getMacAddr();
        TextView tmacAdress = (TextView) findViewById(R.id.macadress);
        tmacAdress.setText(macAdress);

        DhcpInfo dhcpinfo = wifiManager.getDhcpInfo();

        int dnsone = dhcpinfo.dns1;
        String sdhsone = Formatter.formatIpAddress(dnsone);
        TextView tdhsone = (TextView) findViewById(R.id.dhsone);
        tdhsone.setText(sdhsone);

        int dnstwo = dhcpinfo.dns2;
        String sdhstwo = Formatter.formatIpAddress(dnstwo);
        TextView tdhstwo = (TextView) findViewById(R.id.dhstwo);
        tdhstwo.setText(sdhstwo);

        int gateway = dhcpinfo.gateway;
        String sgatway = Formatter.formatIpAddress(gateway);
        TextView tgateway = (TextView) findViewById(R.id.gateway);
        tgateway.setText(sgatway);

        int netmask = dhcpinfo.netmask;
        String snetmask = Formatter.formatIpAddress(netmask);
        TextView tnetmask = (TextView) findViewById(R.id.netmask);
        tnetmask.setText(snetmask);

        int least = dhcpinfo.leaseDuration;
        String sleast = String.valueOf(least);
        TextView tleast = (TextView) findViewById(R.id.least);
        tleast.setText(sleast + " " + "day");

        int server = dhcpinfo.serverAddress;
        String sserver= Formatter.formatIpAddress(server);
        TextView tserver = (TextView) findViewById(R.id.server);
        tserver.setText(sserver);


        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.refresh:
               recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public static String getMacAddr() {

        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    //res1.append(Integer.toHexString(b & 0xFF) + ":");
                    res1.append(String.format("%02X:",b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }

}
