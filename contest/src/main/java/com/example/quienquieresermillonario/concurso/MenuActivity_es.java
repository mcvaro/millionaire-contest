package com.example.quienquieresermillonario.concurso;


import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.example.whowantstobemillionaire.contest.CreditsActivity;
import com.example.whowantstobemillionaire.contest.R;

public class MenuActivity_es extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_es, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){

		switch (item.getItemId()) {
        	case R.id.Credits:
        		startActivity(new Intent(MenuActivity_es.this, CreditsActivity.class));
        		break;
		}
	
		return true;
		
	}

}
