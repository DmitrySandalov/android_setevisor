package com1.example.ems;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setPluginState(PluginState.ON);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.setInitialScale(10);
		myWebView.getSettings().setLoadWithOverviewMode(true);
		myWebView.getSettings().setUseWideViewPort(true);

		myWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				myWebView.loadUrl("javascript: document.getElementById('bodyContainer').getElementsByTagName('div')[0].style.display='none';");
				myWebView.loadUrl("javascript: document.getElementById('bodyContainer').getElementsByTagName('div')[3].style.display='none';");
			}
		});

		myWebView.loadUrl("http://echomsk.onlinetv.ru/player/");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}