package com.example.cn1403;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_1 = (Button) findViewById(R.id.bt_1);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et_1 = (EditText) findViewById(R.id.et_1);
                TextView tv_1 = (TextView) findViewById(R.id.tv_1);

                String aaa = et_1.getText().toString();
                tv_1.setText(aaa);

            }
        });


    }
}