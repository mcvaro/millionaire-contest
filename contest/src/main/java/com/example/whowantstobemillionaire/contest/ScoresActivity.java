package com.example.whowantstobemillionaire.contest;

import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class ScoresActivity extends MenuActivity {


    private static DBScores score;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
		TabHost tab = (TabHost) findViewById(R.id.TabHost1);
		tab.setup();
		tab.addTab(tab.newTabSpec(getString(R.string.local)).setIndicator(getString(R.string.local)).setContent(R.id.ScoresLocal));
		tab.addTab(tab.newTabSpec(getString(R.string.remote)).setIndicator(getString(R.string.remote)).setContent(R.id.ScoresRemote));
		tab.setCurrentTabByTag(getString(R.string.local));
		
		
		score = new DBScores(this);
		List<Score> scores = score.getAllScores();
		TableLayout tableLocal = (TableLayout) findViewById(R.id.ScoresLocal);
		
		for( int i = 0; i < scores.size(); i++){
			
			TableRow rowLocal = new TableRow(this);
			
			TextView textRow = new TextView(this);
			
			textRow.setText(String.valueOf(scores.get(i).getScore()));
			
			
			
			rowLocal.addView(textRow);
			tableLocal.addView(rowLocal);
		}

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.scores, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                score.delete(getContext());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
