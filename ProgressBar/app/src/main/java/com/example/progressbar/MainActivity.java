package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        };

        new Handler(getMainLooper()).postDelayed(runnable,5000);

    }

}