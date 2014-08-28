package com.luca.innocenti.lgs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	private WebView html5;
	private Object savedInstanceState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		html5 = (WebView) findViewById(R.id.webView1);
		html5.getSettings().setJavaScriptEnabled(true);
		html5.setWebChromeClient(new WebChromeClient());
		//mette a tutto schermo la webview
		html5.getSettings().setLoadWithOverviewMode(true);
	    html5.getSettings().setUseWideViewPort(true);
	    //permette il pinch to zoom
	    html5.getSettings().setBuiltInZoomControls(true);

		html5.loadUrl("file:///android_asset/index.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState )
	{
	super.onSaveInstanceState(outState);
	html5.saveState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
	super.onRestoreInstanceState(savedInstanceState);
	html5.restoreState(savedInstanceState);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		// ETN
		if (id == R.id.S1) {
			if (savedInstanceState == null)
				{
				//web.loadUrl(webURL);
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/ETN_RealTime1.png");
				}
			return true;
		}

		if (id == R.id.S2) {
			if (savedInstanceState == null)
				{
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/ETN_RealTime2.png");
				}
			return true;
		}
		if (id == R.id.S3) {
			if (savedInstanceState == null)
				{
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/ETN_RealTime3.png");
				}
			return true;
		}
		if (id == R.id.S4) {
			if (savedInstanceState == null)
				{
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/ETN_RealTime4.png");
				}
			return true;
		}
		if (id == R.id.S5) {
				{
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/etn_sound_realtime.png");
				}
			return true;
		}
		
		if (id == R.id.S6) {
				{
					html5.loadUrl("http://lgs.geo.unifi.it/Etna/ETN_temperature_plot.php");
				}
			return true;
		}
		
		if (id == R.id.S7) {
			if (savedInstanceState == null)
				{
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/ETN_voltage_plot.php");
				}
			return true;
		}
		// MVT
		if (id == R.id.V1) {
			html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/MVT_RealTime_1.png");
			return true;
		}
		if (id == R.id.V2) {
			html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/MVT_RealTime_2.png");
			return true;
		}
		if (id == R.id.V3) {
			html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/MVT_RealTime_3.png");
			return true;
		}
		if (id == R.id.V4) {
			html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/MVT_RealTime_4.png");
			return true;
		}
		// PROCESSING ANCORA NON FUNZIONANTE
		if (id == R.id.V5) {
			html5.loadUrl("");
			
			return true;
		}
		if (id == R.id.V6) {
			html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/MVT_temperature.png");			
			return true;
		}
		
		if (id == R.id.V7) {
			html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/MVT_voltage.png");			
			return true;
		}
		
		if (id == R.id.archivio) {
			Intent intent = new Intent(this, Ricerca.class);
			this.startActivity(intent);

			return true;
		}
		
		


		return super.onOptionsItemSelected(item);
	}
}
