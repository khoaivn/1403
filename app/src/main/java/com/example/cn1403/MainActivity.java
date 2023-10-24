package com.example.cn1403;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("/");
        databaseReference.child("name").setValue("Dai Nam");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListView lv = (ListView) findViewById(R.id.lv);
                DataSnapshot snapshot_student = snapshot.child("student");
                ArrayList<HashMap<String, Object>> list_iteam = new ArrayList<>();
                for (DataSnapshot data_student: snapshot_student.getChildren()){
                    String name = data_student.child("name").getValue(String.class);
                    String code = data_student.child("code").getValue(String.class);
                    Integer number_commit = Integer.parseInt(data_student.child("number_commit").getValue(String.class));
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("text", name);
                    hashMap.put("text1", code);
                    list_iteam.add(hashMap);
                }
                String[] from = {"text", "text1"};
                int to[] = {R.id.tv, R.id.av};
                SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(),
                        list_iteam,
                        R.layout.item_listview,
                        from,
                        to);
                lv.setAdapter(simpleAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}