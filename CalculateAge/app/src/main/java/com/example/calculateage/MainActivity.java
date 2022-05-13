package com.example.calculateage;

import androidx.appcompat.app.AppCompatActivity;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button btnCalculateAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        btnCalculateAge = findViewById(R.id.btnCalculateAge);

        btnCalculateAge.setOnClickListener(view -> {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int age = currentYear-datePicker.getYear();

            Toast.makeText(this,"Age: "+age,Toast.LENGTH_SHORT).show();

        });

    }

}