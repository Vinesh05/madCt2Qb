package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdGroup;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdGroup = findViewById(R.id.rdGroup);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            int selected = rdGroup.getCheckedRadioButtonId();
            String message = "";
            if(selected==R.id.rdFemale){
                message = "Female";
            }
            else if(selected==R.id.rdMale){
                message = "Male";
            }
            else{
                message = "Please select anyone";
            }
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        });


    }

}