package com.greentech.quran.hardware;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class camerahard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);
        Button Cameramain=(Button)findViewById(R.id.cameramain);

        Cameramain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(camerahard.this,CameraActivity.class);
                startActivity(i);

            }
        });
      

    }




}
