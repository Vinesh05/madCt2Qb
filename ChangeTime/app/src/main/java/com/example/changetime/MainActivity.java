package com.example.changetime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button btnSetTime;
    TextView txtCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);
        btnSetTime = findViewById(R.id.btnSetTime);
        txtCurrentTime = findViewById(R.id.txtCurrentTime);

        btnSetTime.setOnClickListener(view -> {
            String currentTime = timePicker.getHour()+":"+timePicker.getMinute();
            txtCurrentTime.setText("Current Time: \n"+currentTime);
        });

    }

}