package com.example.calculateage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtDateOfBirth, edtTxtCurrentDate;
    TextView txtYourAge;
    Calendar currentDate, dateOfBirth;
    Button btnCalculateAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentDate=Calendar.getInstance();
        dateOfBirth=Calendar.getInstance();
        edtTxtDateOfBirth = findViewById(R.id.edtTxtDateOfBirth);
        edtTxtCurrentDate = findViewById(R.id.edtTxtCurrentDate);
        btnCalculateAge = findViewById(R.id.btnCalculateAge);
        txtYourAge = findViewById(R.id.txtYourAge);

        OnDateSetListener dateOfBirthListener = (view, year, month, day)-> {
            dateOfBirth.set(Calendar.YEAR, year);
            dateOfBirth.set(Calendar.MONTH,month);
            dateOfBirth.set(Calendar.DAY_OF_MONTH,day);
            edtTxtDateOfBirth.setText(day+"/"+month+"/"+year);
        };

        edtTxtDateOfBirth.setOnClickListener(view->{
            new DatePickerDialog(MainActivity.this,dateOfBirthListener,2016,6,11).show();
        });

        OnDateSetListener currentDateListener = (view, year, month, day)-> {
            currentDate.set(Calendar.YEAR, year);
            currentDate.set(Calendar.MONTH,month);
            currentDate.set(Calendar.DAY_OF_MONTH,day);
            edtTxtCurrentDate.setText(day+"/"+month+"/"+year);
        };

        edtTxtCurrentDate.setOnClickListener(view->{
            new DatePickerDialog(MainActivity.this,currentDateListener,2016,6,11).show();
        });

        btnCalculateAge.setOnClickListener(view -> {
            int age = currentDate.get(Calendar.YEAR)-dateOfBirth.get(Calendar.YEAR);
            txtYourAge.setText("Your Age: "+age);
        });

    }

}