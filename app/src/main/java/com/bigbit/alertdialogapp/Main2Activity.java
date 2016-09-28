package com.bigbit.alertdialogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String message = getIntent().getStringExtra("friend_request");
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(message);

    }
}
