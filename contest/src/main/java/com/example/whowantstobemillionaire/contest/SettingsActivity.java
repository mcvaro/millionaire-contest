package com.example.whowantstobemillionaire.contest;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class SettingsActivity extends MenuActivity {
	
	public static final String PREF_NAME = "settings";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		
		//set options spinner
		Spinner spin = (Spinner) findViewById(R.id.number_helps);
		Integer[] items = new Integer[]{0,1,2,3};
		ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
		spin.setAdapter(adapter);
			
		
	}

	public void saveSettings(){
		
		EditText userbox = (EditText) findViewById(R.id.userbox);
		Spinner helps = (Spinner) findViewById(R.id.number_helps);
		
		SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		
		editor.putString("data", userbox.getText().toString());
		
		int selectedPositionSpinner = helps.getSelectedItemPosition();
		editor.putInt("spinnerSelection", selectedPositionSpinner);
		
		editor.commit();
		
		
	}
	
	public void restoreSettings(){

		EditText userbox = (EditText) findViewById(R.id.userbox);
		Spinner helps = (Spinner) findViewById(R.id.number_helps);
		
		SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		
		userbox.setText(preferences.getString("data",""));
		
		helps.setSelection(preferences.getInt("spinnerSelection",0));
		
	}
	
	public void onDestroy() {
		super.onDestroy();
		saveSettings();
	}
	
	public void onStart() {
		super.onStart();
		restoreSettings();
	}

}
