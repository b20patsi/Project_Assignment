package com.example.project_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Travel> travelCountrys = new ArrayList<>();
    private ArrayAdapter<Travel> adapter;
    private ListView listView;
    private Button aboutUs;
    private Travel[] travels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_listview);

        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=b20patsi");

        adapter = new ArrayAdapter<Travel>(MainActivity.this, R.layout.list_item_textview,travelCountrys);
        listView.setAdapter(adapter);

        aboutUs = findViewById(R.id.about_us);

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity ==>", "Continue to about us");

                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Travel sendInfo = travelCountrys.get(position);

                Log.d("OnClick ==>","Country clicked: " + sendInfo.getName());

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("country", sendInfo.getName());
                intent.putExtra("location", sendInfo.getLocation());
                intent.putExtra("url", sendInfo.getUrl());
                intent.putExtra("company", sendInfo.getCompany());
                intent.putExtra("cost", sendInfo.getCost());
                startActivity(intent);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            Gson gson = new Gson();

            travels = gson.fromJson(json,Travel[].class);
            travelCountrys.clear();

            for (int i = 0; i < travels.length; i++) {
                travelCountrys.add(travels[i]);
                Log.d("MainAcitivity Async ==>", "Added: " + travels[i]);
            }

            adapter.notifyDataSetChanged();
        }
    }
}