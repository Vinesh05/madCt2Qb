package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtText;
    Button btnSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTxtText = findViewById(R.id.edtTxtText);
        btnSpeak = findViewById(R.id.btnSpeak);
        textToSpeech = new TextToSpeech(this, it -> {
            textToSpeech.setLanguage(Locale.ENGLISH);
        });

        btnSpeak.setOnClickListener(btn -> {
            String text = edtTxtText.getText().toString();
            textToSpeech.speak(text,TextToSpeech.QUEUE_ADD,null,null);
        });

    }

}