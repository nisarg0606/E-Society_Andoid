package com.example.e_society;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView=(WebView) findViewById(R.id.webview);
        mywebView.requestFocus();
        mywebView.getSettings().setAllowFileAccess(true);
        mywebView.getSettings().setJavaScriptEnabled(true);
        mywebView.getSettings().setDomStorageEnabled(true);
        mywebView.getSettings().setAppCacheEnabled(true);
        mywebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mywebView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        mywebView.getSettings().setDatabaseEnabled(true);
        mywebView.getSettings().setLoadsImagesAutomatically(true);
        mywebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mywebView.getSettings().setSupportMultipleWindows(true);
        mywebView.getSettings().setSupportZoom(true);
        mywebView.getSettings().setBuiltInZoomControls(true);
        mywebView.getSettings().setDisplayZoomControls(false);
        mywebView.getSettings().setUseWideViewPort(true);
        mywebView.getSettings().setLoadWithOverviewMode(true);
        mywebView.getSettings().setSaveFormData(true);

        mywebView.setWebViewClient(new WebViewClient());
        // session storage
        mywebView.getSettings().setDomStorageEnabled(true);
        mywebView.loadUrl("https://e-society2022.herokuapp.com/");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public static class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}