package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtPhone, edtTxtMessage;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        edtTxtPhone = findViewById(R.id.edtTxtPhone);
        edtTxtMessage = findViewById(R.id.edtTxtMessage);
        btnSend = findViewById(R.id.btnSend);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 112);

        btnSend.setOnClickListener(view -> {
            String sPhone = edtTxtPhone.getText().toString().trim();
            String sMessage = edtTxtMessage.getText().toString().trim();

            if (!sPhone.equals("") && !sMessage.equals("")){
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(sPhone, null, sMessage, null, null);
                Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Enter value first.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}