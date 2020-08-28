package com.example.smsreadingusingbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView txt_jjj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_jjj = findViewById(R.id.txt_jjj);
        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText) {
                Log.d("Text",messageText);
                txt_jjj.setText(messageText);
                String[]  otp = messageText.split(" ");
//                Toast.makeText(MainActivity.this,"Message: "+messageText,Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"Otp: "+otp[0],Toast.LENGTH_LONG).show();
            }
        });
    }
}