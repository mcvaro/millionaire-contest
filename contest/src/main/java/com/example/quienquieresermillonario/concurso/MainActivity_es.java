package com.example.quienquieresermillonario.concurso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.whowantstobemillionaire.contest.MainActivity;
import com.example.whowantstobemillionaire.contest.R;
import com.example.whowantstobemillionaire.contest.ScoresActivity;
import com.example.whowantstobemillionaire.contest.SettingsActivity;

public class MainActivity_es extends MenuActivity_es {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_es);
		
		//Boton Play (id = PlayButon creado en res/activity_main.xml
		Button play = (Button) findViewById(R.id.ButtonPlay);
		
		//asociar boton a PlayActivity
		play.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity_es.this, PlayActivity_es.class));
			}
		});
		
		
		//Boton Settings (id = SettingsButton creado en res/activity_main.xml
		Button Settings = (Button) findViewById(R.id.ButtonSettings);
		
		//asociar boton a SettingsActivity
		Settings.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity_es.this, SettingsActivity_es.class));
					}
		});
		
		
		//Boton Scores (id = ScoresButton creado en res/activity_main.xml
		Button Scores = (Button) findViewById(R.id.ButtonScores);
				
		//asociar boton a ScoresActivity
		Scores.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity_es.this, ScoresActivity_es.class));
			}
			
		});

        ImageButton spanish = (ImageButton) findViewById(R.id.spanish);
        spanish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_es.this, MainActivity_es.class));

            }

        });

        ImageButton english = (ImageButton) findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_es.this, MainActivity.class));

            }

        });
	}
	
	
}


