package com.example.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ZaebalaSuka extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaebala_suka);

        webView = (WebView) findViewById(R.id.zs);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://stackoverflow.com/questions/68021770/setonnavigationitemselectedlistener-deprecated");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_Zaebala);
        bottomNavigationView.setSelectedItemId(R.id.zs);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.yt:
                        startActivity(new Intent(getApplication()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.zs:


                        return true;
                }
                return false;
            }

        });

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();

        }

    }
}