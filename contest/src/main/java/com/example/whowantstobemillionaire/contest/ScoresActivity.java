package com.example.whowantstobemillionaire.contest;

import java.util.List;

import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;



public class ScoresActivity extends MenuActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_scores);
		TabHost tab = (TabHost) findViewById(R.id.TabHost1);
		tab.setup();
		tab.addTab(tab.newTabSpec("Local").setIndicator("Local").setContent(R.id.ScoresLocal));
		tab.addTab(tab.newTabSpec("Remote").setIndicator("Remote").setContent(R.id.ScoresRemote));
		tab.setCurrentTabByTag("Local");
		
		
		DBScores score = new DBScores(this);
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

}
