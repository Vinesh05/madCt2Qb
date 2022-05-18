package com.example.changetime;

import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
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

        OnTimeSetListener timeSetListener = new OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker tp, int hour, int minute) {
                timePicker.setHour(hour);
                timePicker.setMinute(minute);
                txtCurrentTime.setText("Current Time: (H:M)\n"+hour+":"+minute);
            }
        };

        btnSetTime.setOnClickListener(view -> {
            TimePickerDialog tpDialog = new TimePickerDialog(this,timeSetListener,3,0,false);
            tpDialog.show();
        });

    }

}