package com.example.project_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String country = intent.getStringExtra("name_of_country");
        String location = intent.getStringExtra("name_of_location");

        textView = findViewById(R.id.test_text);

        textView.setText(country + " ligger i " + location);
    }
}