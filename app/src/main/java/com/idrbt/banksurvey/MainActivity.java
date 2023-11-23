package com.idrbt.banksurvey;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private static final int SPLASH_SCREEN_DURATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // Load and display the GIF using Glide
        ImageView splashImageView = findViewById(R.id.splashImageView);
        Glide.with(this).asGif().load(R.drawable.ani3).into(splashImageView);

        // Handler to delay the WebView loading
        new Handler().postDelayed(() -> {
            setContentView(R.layout.activity_main);
            initializeWebView();
        }, SPLASH_SCREEN_DURATION);
    }

    private void initializeWebView() {
        // Initialize WebView
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        // Enable JavaScript (if your website requires it)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load the website URL
        webView.loadUrl("https://github.com/5gucl-idrbt/Local-Language-for-Workflows/issues/new?assignees=5gucl-idrbt&labels=Survey&projects=&template=local.yml&title=%5BSurvey+Form%5D%3A+");

        // Make the WebView visible
        webView.setVisibility(WebView.VISIBLE);
    }

    // Handle back button press to navigate within the WebView
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
