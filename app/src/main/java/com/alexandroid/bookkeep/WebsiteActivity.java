package com.alexandroid.bookkeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        Intent intent = new Intent();
        if(intent != null) {
            String url = intent.getStringExtra("url");
            webView = findViewById(R.id.webView);
            //webView.loadUrl(url);
            webView.loadUrl("https://www.lopezalex.com/");
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }
}