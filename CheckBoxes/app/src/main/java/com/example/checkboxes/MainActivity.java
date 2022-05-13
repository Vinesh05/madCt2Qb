package com.example.checkboxes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxHouse, chkBoxCar;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkBoxHouse = findViewById(R.id.chkBoxHouse);
        chkBoxCar = findViewById(R.id.chkBoxCar);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            String selected = "You own: ";
            if(chkBoxHouse.isChecked()){
                selected+=" House";
            }
            if(chkBoxCar.isChecked()){
                selected+=" Car";
            }
            Toast.makeText(this,selected,Toast.LENGTH_SHORT).show();
        });

    }

}