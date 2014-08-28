package com.luca.innocenti.lgs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class Ricerca extends Activity {


	private DatePicker datapicker;
	private int year;
	private int day;
	private int month;
	private Spinner spinner_sensori;
	private Button btn_ricerca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ricerca);
		
		//mette a posto il calendario
		datapicker = (DatePicker)findViewById(R.id.datePicker1);
		final Calendar c = Calendar.getInstance();
		//setta la data odierna
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        datapicker.init(year, month, day,new OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker view, 
              int myear, int mmonth,int mday) {
            	year = myear;
            	month = mmonth;
            	day=mday;
            }}); 
        	
        //fa sparire il calendario
        datapicker.setCalendarViewShown(false);
        
        //mette a posto lo spinner dei sensori
    	spinner_sensori = (Spinner) findViewById(R.id.spinner1);
    	List<String> list = new ArrayList<String>();
    	list.add("ETN-1");
    	list.add("ETN-2");
    	list.add("ETN-3");
    	list.add("ETN-4");
    	list.add("MVT-1");
    	list.add("MVT-2");
    	list.add("MVT-3");
    	list.add("MVT-4");
    	
    	btn_ricerca = (Button) findViewById(R.id.button1);
    	
    	btn_ricerca.setOnClickListener(new View.OnClickListener() {
           
			public void onClick(View v) {
            	 String sensore = String.valueOf(spinner_sensori.getSelectedItem());
                 Log.d("ETN",Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day)+"/"+ sensore);
                 Intent intent = new Intent(getBaseContext(), Arc.class);
                 intent.putExtra("day",day);
                 intent.putExtra("month",month);
                 intent.putExtra("year",year);
                 intent.putExtra("sensore",sensore);
     			 startActivity(intent);
                 
             }
         });
    	
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner_sensori.setAdapter(dataAdapter);

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ricerca, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
