package com.example.project_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private WebView webView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String country = intent.getStringExtra("name_of_country");
        String location = intent.getStringExtra("name_of_location");

        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebViewClient WebViewClient = new WebViewClient();
        webView.setWebViewClient(WebViewClient);

        textView = findViewById(R.id.test_text);

        textView.setText(country + " ligger i " + location);
    }
}