package com.example.timedatepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;

    int mHour;
    int mMinute;

    Button btnShowDialog;
    TextView txtDateAndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = findViewById(R.id.btnShowDialog);
        txtDateAndTime = findViewById(R.id.txtTimeAndDate);

        btnShowDialog.setOnClickListener(view->{
            datePicker();
        });

    }

    private void datePicker(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, monthOfYear, dayOfMonth) -> {
                    date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    timePicker();
                },
                mYear,
                mMonth,
                mDay);
        datePickerDialog.show();
    }

    private void timePicker(){
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minute) -> {
                    mHour = hourOfDay;
                    mMinute = minute;
                    txtDateAndTime.setText(date_time+"\n"+hourOfDay + ":" + minute);
                },
                mHour,
                mMinute,
                false
        );
        timePickerDialog.show();
    }

}