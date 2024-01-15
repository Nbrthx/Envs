package com.syscers.envs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/index.html");
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to quit?")
                .setPositiveButton("Quit", (dialog, id) -> finish())
                .setNegativeButton("Cancel", (dialog, id) -> {

                });

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            builder.create().show();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}