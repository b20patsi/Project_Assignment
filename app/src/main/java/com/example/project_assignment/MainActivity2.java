package com.example.project_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private WebView webView;
    private TextView textView;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String country = intent.getStringExtra("country");
        String location = intent.getStringExtra("location");
        String url = intent.getStringExtra("url");
        String company = intent.getStringExtra("company");
        String cost = intent.getStringExtra("cost");

        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebViewClient NewWebViewClient = new WebViewClient();
        webView.setWebViewClient(NewWebViewClient);

        textView = findViewById(R.id.receive_text);

        webView.loadUrl(url);

        textView.setText("Vi på " + company + " flyger er till vackra " + country + " som ligger i " + location + ". Priset för denna resa är " + cost + " kr per vuxen, barn reser för halva priset.");

        backBtn = findViewById(R.id.move_back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MoreInfo ==>", "Back to main page");

                finish();
            }
        });
    }
}