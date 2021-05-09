package com.example.project_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Travel> travelCountrys = new ArrayList<>();
    private ArrayAdapter<Travel> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.mainListView);

        adapter = new ArrayAdapter<Travel>(MainActivity.this, R.layout.list_item_textview,travelCountrys);
        listView.setAdapter(adapter);
    }


}