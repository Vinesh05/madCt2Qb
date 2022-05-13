package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        String[] listItems = getResources().getStringArray(R.array.string_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.activity_list_item,android.R.id.text1,listItems);
        listView.setAdapter(arrayAdapter);

    }

}