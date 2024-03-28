
























































































































package com.example.prog6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText mobileTxt, messageTxt;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mobileTxt = findViewById(R.id.mobileTxt);
        messageTxt = findViewById(R.id.messageTxt);
        sendBtn = findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(mobileTxt.getText().toString(), null, messageTxt.getText().toString(), null, null);
                    Snackbar.make(view, "SMS Sent Successfully", Snackbar.LENGTH_SHORT).show();
                }catch (Exception e){
                    Snackbar.make(view, "Failure in sending SMS", Snackbar.LENGTH_SHORT).show();
                }
            }

        });
    }
}
