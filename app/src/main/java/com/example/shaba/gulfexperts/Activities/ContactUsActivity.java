package com.example.shaba.gulfexperts.Activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.shaba.gulfexperts.R;

public class ContactUsActivity extends AppCompatActivity {

    TextInputEditText name, email, topic, message ;
    Button sendBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction () ;

        name = (TextInputEditText) findViewById(R.id.textInputEditTextName) ;
        email = (TextInputEditText) findViewById(R.id.textInputEditTextEmail) ;
        topic = (TextInputEditText) findViewById(R.id.textInputEditTextTopic) ;
        message = (TextInputEditText) findViewById(R.id.textInputEditTextMeassage) ;
    }
}
