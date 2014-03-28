package com.example.quienquieresermillonario.concurso;

import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.whowantstobemillionaire.contest.DBScores;
import com.example.whowantstobemillionaire.contest.MenuActivity;
import com.example.whowantstobemillionaire.contest.R;
import com.example.whowantstobemillionaire.contest.Score;

import java.util.List;


public class
        ScoresActivity_es extends MenuActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_scores);
		TabHost tab = (TabHost) findViewById(R.id.TabHost1);
		tab.setup();
		tab.addTab(tab.newTabSpec("Local").setIndicator("Local").setContent(R.id.ScoresLocal));
		tab.addTab(tab.newTabSpec("Remoto").setIndicator("Remoto").setContent(R.id.ScoresRemote));
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
