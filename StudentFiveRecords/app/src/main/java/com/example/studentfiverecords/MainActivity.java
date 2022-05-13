package com.example.studentfiverecords;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, roll_no;
    Button add, delete;
    TextView allRecords;
    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        roll_no = findViewById(R.id.roll_no);
        add = findViewById(R.id.btnAdd);
        delete = findViewById(R.id.btnDelete);
        allRecords = findViewById(R.id.allRecords);

        db = new MyDbHelper(this);
        add.setOnClickListener(view -> {
            String nameStr = name.getText().toString();
            int rollNoInt = Integer.parseInt(this.roll_no.getText().toString());

            if(db.addStudent(rollNoInt,nameStr)){
                Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                getAllRecords();
            }
            else
                Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
        });

        delete.setOnClickListener(view -> {
            int rollNoInt = Integer.parseInt(MainActivity.this.roll_no.getText().toString());
            if(db.deleteStudent(rollNoInt)){
                Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                getAllRecords();
            }
            else
                Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
        });

        getAllRecords();

    }

    private void getAllRecords(){
        Cursor res = db.getStudents();
        if(res.getCount()==0){
            db.addStudent(1,"Ethan");
            db.addStudent(2,"Alice");
            db.addStudent(3,"Franklin");
            db.addStudent(4,"Trevor");
            db.addStudent(5,"Michael");
            getAllRecords();
        }
        else{
            String records = "";
            while(res.moveToNext()){
                records+="\nRoll no.: "+res.getString(0);
                records+=" Name: "+res.getString(1)+"";
            }
            allRecords.setText(records);
        }
    }
}