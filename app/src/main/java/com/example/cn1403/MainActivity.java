package com.example.cn1403;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler dbHandler = new DBHandler(MainActivity.this);
        dbHandler.addNewCourse("Nam nhat", "Hoc nhung mon dai cuong");
        dbHandler.readCourses();

        ListView lv = (ListView) findViewById(R.id.lv);

        ArrayList<HashMap<String, Object>> list_iteam = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("image", R.drawable.ic_launcher_background);
            hashMap.put("text", "Thu" + i);
            hashMap.put("text1", "Thu" + i);
            list_iteam.add(hashMap);

        }
        String[] from = {"image", "text ","text1"};

        int to[] = {R.id.iv, R.id.tv, R.id.av};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                list_iteam,
                R.layout.item_listview,
                from,
                to);
        lv.setAdapter(simpleAdapter);


    }
}