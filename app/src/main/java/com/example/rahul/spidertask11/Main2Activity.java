package com.example.rahul.spidertask11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView T1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        T1=(TextView)findViewById(R.id.text);
        Intent intent = getIntent();
        String task = intent.getExtras().getString("item");

        T1.setText(task);

    }
}
