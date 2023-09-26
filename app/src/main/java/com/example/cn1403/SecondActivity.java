package com.example.cn1403;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String string = getIntent().getStringExtra("name_string");
        TextView tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_2.setText(string);
    }
}