package com.example.storeretrievestudentdetails;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, roll_no, branch, marks, percentage;
    Button add, retrieve;
    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        roll_no = findViewById(R.id.roll_no);
        branch = findViewById(R.id.branch);
        marks = findViewById(R.id.marks);
        percentage = findViewById(R.id.percentage);
        add = findViewById(R.id.btnAdd);
        retrieve = findViewById(R.id.btnRetrieve);

        db = new MyDbHelper(this);
        add.setOnClickListener(view -> {
            String nameStr = name.getText().toString();
            int rollNoInt = Integer.parseInt(roll_no.getText().toString());
            String branchStr = branch.getText().toString();
            int marksInt = Integer.parseInt(marks.getText().toString());
            int percentageInt = Integer.parseInt(percentage.getText().toString());

            if(db.addStudent(rollNoInt,nameStr,branchStr,marksInt,percentageInt)){
                Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
        });

        retrieve.setOnClickListener(view -> {
            int rollNoInt = Integer.parseInt(this.roll_no.getText().toString());
            Cursor cursor = db.getStudents(rollNoInt);
            if(cursor.getCount()!=0){
                cursor.moveToFirst();
                String rollNoStr = cursor.getString(0);
                String nameStr = cursor.getString(1);
                String branchStr = cursor.getString(2);
                String marksStr = cursor.getString(3);
                String percentageStr = cursor.getString(4);

                String message = "Roll No.: "+rollNoStr+
                        "\nName: "+nameStr+
                        "\nBranch: "+branchStr+
                        "\nMarks: "+marksStr+
                        "\nPercentage: "+percentageStr;

                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

            }
        });

    }

}