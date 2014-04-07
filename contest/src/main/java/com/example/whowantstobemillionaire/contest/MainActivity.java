package com.example.whowantstobemillionaire.contest;

import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


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
    //Con la tecla atrás no volvemos al activity anterior, salimos de la app
     public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return false;
    }
}


