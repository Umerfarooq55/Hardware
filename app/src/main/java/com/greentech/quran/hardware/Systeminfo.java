package com.greentech.quran.hardware;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;

public class Systeminfo extends AppCompatActivity {
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systeminfo);


        TextView serial = (TextView) findViewById(R.id.serial);
        serial.setText(Build.SERIAL);

        TextView model = (TextView) findViewById(R.id.model);
        model.setText(Build.MODEL);

        TextView id = (TextView) findViewById(R.id.id);
        id.setText(Build.ID);

        TextView manufacture = (TextView) findViewById(R.id.manufacture);
        manufacture.setText(Build.MANUFACTURER);

        TextView brand = (TextView) findViewById(R.id.brand);
        brand.setText(Build.BRAND);

        TextView type = (TextView) findViewById(R.id.type);
        type.setText(Build.MODEL);

        TextView user = (TextView) findViewById(R.id.user);
        user.setText(Build.USER);

        TextView incremental = (TextView) findViewById(R.id.incremental);
        incremental.setText(Build.VERSION.INCREMENTAL);

        TextView sdk = (TextView) findViewById(R.id.sdk);
        sdk.setText(Build.VERSION.SDK);

        TextView bored = (TextView) findViewById(R.id.bored);
        bored.setText(Build.BOARD);

        TextView host = (TextView) findViewById(R.id.host);
        host.setText(Build.HOST);

        TextView fingerprint = (TextView) findViewById(R.id.fingerprint);
        fingerprint.setText(Build.FINGERPRINT);

        TextView version_code = (TextView) findViewById(R.id.versioncode);
        version_code.setText(Build.VERSION.RELEASE);
     TextView product = (TextView) findViewById(R.id.product);
        product.setText(Build.PRODUCT);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        String shight = String.valueOf(height);
        String swidth = String.valueOf(width);
        TextView dimension = (TextView) findViewById(R.id.dimension);
        dimension.setText(swidth + "x" + shight);

        double wi=(double)width/(double)displayMetrics.xdpi;
        double hi=(double)height/(double)displayMetrics.ydpi;
        double x = Math.pow(wi,2);
        double y = Math.pow(hi,2);
        double screenInches = Math.sqrt(x+y);
        double finalValue = Math.round( screenInches * 100.0 ) / 100.0;
        TextView size = (TextView) findViewById(R.id.size);
        size.setText(finalValue + " Inch");

        int density = displayMetrics.densityDpi;
        String sdensity = String.valueOf(density);
        TextView tdensity = (TextView) findViewById(R.id.density);
        tdensity.setText(sdensity + " dpi");

        int densityclass = getResources().getDisplayMetrics().densityDpi;
        switch(density)
        {
            case DisplayMetrics.DENSITY_LOW:
                TextView tdensityclasslow= (TextView) findViewById(R.id.densityclass);
                tdensityclasslow.setText("LDPI" + " -" + " Low");
                break;
            case DisplayMetrics.DENSITY_MEDIUM:

                TextView tdensityclassmed= (TextView) findViewById(R.id.densityclass);
                tdensityclassmed.setText("MDPI" + " -" + " Medium");
                break;
            case DisplayMetrics.DENSITY_HIGH:

                TextView tdensityclasshigh= (TextView) findViewById(R.id.densityclass);
                tdensityclasshigh.setText("HDPI" + " -" + " High");
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                TextView tdensityclasshighh= (TextView) findViewById(R.id.densityclass);
                tdensityclasshighh.setText("XHDPI" + " -" + " High");
                break;
        }

        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        long availableMegs = mi.availMem / 1048576L;
        String availableram = String.valueOf(availableMegs);
        TextView tavailableram = (TextView) findViewById(R.id.availableram);
        tavailableram.setText(availableram + " MB");

        activityManager.getMemoryInfo(mi);
        long totalMegs = mi.totalMem / 1048576L;
        String totalram = String.valueOf(totalMegs);
        TextView ttotalram = (TextView) findViewById(R.id.totalram);
        ttotalram.setText(totalram + " MB");


        long usedram = totalMegs-availableMegs;
        String susedram = String.valueOf(usedram);
        TextView tusedram = (TextView) findViewById(R.id.usedram);
        tusedram.setText(susedram + " MB");

        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        long available = availableBlocks * blockSize;
        long finalValueharda = (long) (Math.round( available * 100.0 ) / 100.0);
        String savail = String.valueOf(formatSize(finalValueharda));
        TextView tavail = (TextView) findViewById(R.id.available);
        tavail.setText(savail);

        long blockSizetotal = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        long totalsize =  totalBlocks * blockSizetotal;
        long finalValuehardt = (long) (Math.round( totalsize * 100.0 ) / 100.0);
        String stotalsize = String.valueOf(formatSize(finalValuehardt));
        TextView ttoalsize = (TextView) findViewById(R.id.capacity);
        ttoalsize.setText(stotalsize);

        long usedsize = totalsize - available;
        long finalValuehardu = (long) (Math.round( usedsize * 100.0 ) / 100.0);
        String susedsize = String.valueOf(formatSize(finalValuehardu));
        TextView tusedsize = (TextView) findViewById(R.id.used);
        tusedsize.setText(susedsize);
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


    public static String formatSize(long size) {
        String suffix = null;

        if (size >= 1024*100) {
            suffix = " GB";
            size /= 1024;
            if (size >= 1024) {
                suffix = " MB";
                size /= 1024;
            }
        }
        StringBuilder resultBuffer = new StringBuilder(Long.toString(size));

        int commaOffset = resultBuffer.length() - 3;
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',');
            commaOffset -= 3;
        }
        if (suffix != null) resultBuffer.append(suffix);
        return resultBuffer.toString();
    }

}
