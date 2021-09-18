package com.cihan.newsfeedbycihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

public class NewsScreenActivity extends AppCompatActivity {

    private WebView mWebView;
    String mlink;
    URL myurl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_screen);

        Intent intent = getIntent();
        mlink = intent.getStringExtra("mlink");
        try {
            myurl = new URL(mlink);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        mWebView = (WebView) findViewById(R.id.WebView);
        mWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(String.valueOf(myurl));



    }
}