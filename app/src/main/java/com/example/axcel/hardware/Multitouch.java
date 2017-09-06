package com.example.axcel.hardware;

import android.app.AlertDialog;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

public class Multitouch extends AppCompatActivity implements MultiTouchCanvas.MultiTouchStatusListener {
    private TextView txtInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_multitouch);

        txtInfo = (TextView) findViewById(R.id.txtInfo);
        ((MultiTouchCanvas) findViewById(R.id.multiTouchView)).setStatusListener(this);
//
//        Button btnAbout = (Button) findViewById(R.id.btnAbout);
//        btnAbout.getBackground().setAlpha(128);
//        btnAbout.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                showAboutDialog();
//            }
//        });
    }

    @Override
    public void onStatus(List<Point> pointerLocations, int numPoints) {
        String str = String.format(getResources().getString(R.string.num_touches), Integer.toString(numPoints));
        for (int i = 0; i < numPoints; i++) {
            str += "\n";
            str += pointerLocations.get(i).x + ", " + pointerLocations.get(i).y;
        }
        txtInfo.setText(str);
    }

    private void showAboutDialog() {
        new AlertDialog.Builder(Multitouch.this)
                .setPositiveButton(R.string.ok, null)
                .setTitle(R.string.about)
                .setMessage(R.string.str_about)
                .create()
                .show();
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


