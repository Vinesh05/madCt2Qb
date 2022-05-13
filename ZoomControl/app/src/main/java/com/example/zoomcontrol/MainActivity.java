package com.example.zoomcontrol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {

    ZoomControls zoomControls;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoomControls = findViewById(R.id.zoomControls);
        imgView = findViewById(R.id.imgView);

        zoomControls.setOnZoomInClickListener(view -> {
            imgView.setScaleX(imgView.getScaleX()+1);
            imgView.setScaleY(imgView.getScaleY()+1);
        });

        zoomControls.setOnZoomOutClickListener(view-> {
            imgView.setScaleX(imgView.getScaleX()-1);
            imgView.setScaleY(imgView.getScaleY()-1);
        });

    }
}