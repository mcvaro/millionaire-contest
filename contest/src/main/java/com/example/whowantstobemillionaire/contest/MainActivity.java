package com.example.whowantstobemillionaire.contest;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Boton Play (id = PlayButon creado en res/activity_main.xml
		Button play = (Button) findViewById(R.id.ButtonPlay);
		
		//asociar boton a PlayActivity
		play.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PlayActivity.class));
			}
		});
		
		
		//Boton Settings (id = SettingsButton creado en res/activity_main.xml
		Button Settings = (Button) findViewById(R.id.ButtonSettings);
		
		//asociar boton a SettingsActivity
		Settings.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SettingsActivity.class));
					}
		});
		
		
		//Boton Scores (id = ScoresButton creado en res/activity_main.xml
		Button Scores = (Button) findViewById(R.id.ButtonScores);
				
		//asociar boton a ScoresActivity
		Scores.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ScoresActivity.class));
			}
			
		});
	}
	
	
}


