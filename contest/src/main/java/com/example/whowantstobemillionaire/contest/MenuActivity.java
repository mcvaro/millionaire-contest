package com.example.whowantstobemillionaire.contest;


import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){

		switch (item.getItemId()) {
        	case R.id.Credits:
        		startActivity(new Intent(MenuActivity.this, CreditsActivity.class));
        		break;
		}
	
		return true;
		
	}

}
