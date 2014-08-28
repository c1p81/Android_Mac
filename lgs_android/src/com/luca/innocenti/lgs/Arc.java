package com.luca.innocenti.lgs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

public class Arc extends Activity {

	private int day;
	private int month;
	private int year;
	private String sensore;
	private TextView titolo;
	private WebView html5;
	private String stazione;
	private String se;
	private Object savedInstanceState;
	private java.text.SimpleDateFormat sdf;
	private Calendar da;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// formato dati
	    // ETN_20140812_X_Y.png
	    // XX e' l'ora (da 1 "00-06" a 4 "18-24)
	    // YY e' il sensore
		// http://lgs.geo.unifi.it/Etna/DatabaseFIG/"
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arc);
		day =getIntent().getIntExtra("day", 0); 
		month =getIntent().getIntExtra("month", 0);
		year =getIntent().getIntExtra("year", 0);
		sensore =(String) getIntent().getExtras().get("sensore");
		stazione = sensore.substring(0, 3);
		se = sensore.substring(4, 5);
		
		titolo = (TextView)findViewById(R.id.textView1);
		
		
		sdf = new SimpleDateFormat("yyyyMMdd");	
		da = new GregorianCalendar(year,month,day);

		Log.d("LGS",stazione+" "+se+sdf.format(da.getTime()));
		
		titolo.setText(sensore +"  "+ sdf.format(da.getTime())+ "/00:06");
		

		
		html5 = (WebView) findViewById(R.id.webView1);
		html5.getSettings().setJavaScriptEnabled(true);
		html5.setWebChromeClient(new WebChromeClient());
		//mette a tutto schermo la webview
		html5.getSettings().setLoadWithOverviewMode(true);
	    html5.getSettings().setUseWideViewPort(true);
	    //permette il pinch to zoom
	    html5.getSettings().setBuiltInZoomControls(true);
		html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/"+sdf.format(da.getTime())+"/"+stazione+"_"+sdf.format(da.getTime())+"_1_"+se+".png");
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arc, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		// ETN
		if (id == R.id.O1) {
					titolo.setText(sensore +"  "+ sdf.format(da.getTime())+"/00-06");
					if (savedInstanceState == null)
						{
						//web.loadUrl(webURL);
						html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/"+sdf.format(da.getTime())+"/"+stazione+"_"+sdf.format(da.getTime())+"_1_"+se+".png");
						}
					return true;
				}

		if (id == R.id.O2) {
				titolo.setText(sensore +"  "+ sdf.format(da.getTime())+"/06-12");

					if (savedInstanceState == null)
						{
						html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/"+sdf.format(da.getTime())+"/"+stazione+"_"+sdf.format(da.getTime())+"_2_"+se+".png");
						}
					return true;
		}
		
		if (id == R.id.O3) {
			titolo.setText(sensore +"  "+ sdf.format(da.getTime())+"/12-18");

			if (savedInstanceState == null)
				{
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/"+sdf.format(da.getTime())+"/"+stazione+"_"+sdf.format(da.getTime())+"_3_"+se+".png");
				}
			return true;
}

		if (id == R.id.O4) {
			titolo.setText(sensore +"  "+ sdf.format(da.getTime())+"/18-24");

			if (savedInstanceState == null)
				{
				html5.loadUrl("http://lgs.geo.unifi.it/Etna/DatabaseFIG/"+sdf.format(da.getTime())+"/"+stazione+"_"+sdf.format(da.getTime())+"_4_"+se+".png");
				}
			return true;
}

		
		return super.onOptionsItemSelected(item);
	}
}
