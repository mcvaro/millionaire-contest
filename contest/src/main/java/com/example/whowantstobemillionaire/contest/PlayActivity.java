package com.example.whowantstobemillionaire.contest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.widget.Toast;

public class PlayActivity extends Activity {

	public List<Question> list = new ArrayList<Question>();
	public int  nquest = 0;
	public int score[] = {0, 100, 200, 300, 400, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
	public SQLiteDatabase db;
	public int helps;
	public boolean flagHelp = false;
	public int totalScore = 0;
    public int secureScore = 0;
    private int maxHelps = 2;

	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

         readQuestionsXML();
        setQuestions();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		
		
		case R.id.phone:
			
			if(helps != getMaxHelps()){
				setButtonBackgroundColor(list.get(nquest).getPhone());
				helps++;
				flagHelp = true;}
			
			else flagHelp = false;
			break;
			
		case R.id.fifty:
			
			if(helps != getMaxHelps()){
				setAnswerInvisible(list.get(nquest).getFifty1());
				setAnswerInvisible(list.get(nquest).getFifty2());
				helps++;
				flagHelp = true;}
			
			else flagHelp = false;
			break;
		
		case R.id.audience:
			
			if(helps != getMaxHelps()){
				setButtonBackgroundColor(list.get(nquest).getAudience());
				helps++;
				flagHelp = true;}
			
			else flagHelp = false;
			break;

        case R.id.end:
            saveScore(totalScore);
            finish();
		}

		return true;

	}

    public int getMaxHelps() {

        SharedPreferences preferences = getSharedPreferences(SettingsActivity.PREF_NAME, Context.MODE_PRIVATE);
        int helps = preferences.getInt("maxHelps", 0);
        return helps;
    }
	
	public void setAnswerInvisible(int button){
		
		 switch (button){
		 
		 case 1: 	View ans1= findViewById(R.id.ans1);
					ans1.setVisibility(View.GONE);
					break;
					
		 case 2: 	View ans2= findViewById(R.id.ans2);
					ans2.setVisibility(View.GONE);
					break;
					
		 case 3: 	View ans3= findViewById(R.id.ans3);
					ans3.setVisibility(View.GONE);
					break;
					
		 case 4: 	View ans4= findViewById(R.id.ans4);
					ans4.setVisibility(View.GONE);
					break;
		 }
		
	}

	
	
	public void setButtonBackgroundColor(int button){
		
		switch (button){
		 
		case 1: 	Button ans1= (Button) findViewById(R.id.ans1);
		  			ans1.setBackgroundResource(android.R.drawable.alert_dark_frame);
		  			ans1.setTextColor(Color.WHITE);
					break;
					
		case 2: 	Button ans2= (Button) findViewById(R.id.ans2);
					ans2.setBackgroundResource(android.R.drawable.alert_dark_frame);
					ans2.setTextColor(Color.WHITE);
					break;
					
		case 3: 	Button ans3= (Button) findViewById(R.id.ans3);
					ans3.setBackgroundResource(android.R.drawable.alert_dark_frame);
					ans3.setTextColor(Color.WHITE);
					break;
					
		case 4: 	Button ans4= (Button) findViewById(R.id.ans4);
					ans4.setBackgroundResource(android.R.drawable.alert_dark_frame);
					ans4.setTextColor(Color.WHITE);
					break;
		 }
		
	}
	


	public void readQuestionsXML() {
		
		Question quest;
		int eventType;
        String[] answer = new String[4];
		
		try {
			
			XmlPullParser parser = null;
			InputStream is = getResources().openRawResource(R.raw.questions0001);
			parser = XmlPullParserFactory.newInstance().newPullParser();
			parser.setInput(is, null);
			
			
			eventType = XmlPullParser.START_DOCUMENT;
			
		
			
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {

					answer[0] = parser.getAttributeValue(null, "answer1");
					answer[1] = parser.getAttributeValue(null, "answer2");
					answer[2] = parser.getAttributeValue(null, "answer3");
				    answer[3] = parser.getAttributeValue(null, "answer4");
					String audience = parser.getAttributeValue(null, "audience");
					String fifty1 = parser.getAttributeValue(null, "fifty1");
					String fifty2 = parser.getAttributeValue(null, "fifty2");
					String number = parser.getAttributeValue(null, "number");
					String phone = parser.getAttributeValue(null, "phone");
					String right = parser.getAttributeValue(null, "right");
					String text = parser.getAttributeValue(null, "text");

					quest = new Question(number, text, answer[0], answer[1], answer[2], answer[3], right, audience, phone, fifty1, fifty2);
					
					
					if(answer[0] == null){
						eventType = parser.next();
						}
					
					else{list.add(quest);
					eventType = parser.next();}
					
					
					
				}
				else{ eventType = parser.next();}
			}
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	public void setQuestions() {
		
		TextView b = (TextView) findViewById(R.id.bet);
		b.setText(getString(R.string.play_for) + score[nquest]);
		

		TextView n = (TextView) findViewById(R.id.number);
		n.setText(getString(R.string.question) + list.get(nquest).getNumber());
		

		TextView q = (TextView) findViewById(R.id.question);
		q.setText(list.get(nquest).getText());
		

		Button a1 = (Button) findViewById(R.id.ans1);
		a1.setText(list.get(nquest).getAnswer(0));
		a1.setTextColor(Color.BLACK);
		if(flagHelp == true){
			a1.setVisibility(View.VISIBLE);
			a1.setBackgroundResource(android.R.drawable.btn_default);
			a1.setTextColor(Color.BLACK);}

		Button a2 = (Button) findViewById(R.id.ans2);
		a2.setText(list.get(nquest).getAnswer(1));
		a2.setTextColor(Color.BLACK);
		
		if(flagHelp == true){
			a2.setVisibility(View.VISIBLE);
			a2.setBackgroundResource(android.R.drawable.btn_default);
			a2.setTextColor(Color.BLACK);}

		Button a3 = (Button) findViewById(R.id.ans3);
		a3.setText(list.get(nquest).getAnswer(2));
		a3.setTextColor(Color.BLACK);
		
		if(flagHelp == true){
			a3.setVisibility(View.VISIBLE);
			a3.setBackgroundResource(android.R.drawable.btn_default);
			a2.setTextColor(Color.BLACK);}

		Button a4 = (Button) findViewById(R.id.ans4);
		a4.setText(list.get(nquest).getAnswer(3));
		a4.setTextColor(Color.BLACK);
		
		if(flagHelp == true){
			a4.setVisibility(View.VISIBLE);
			a4.setBackgroundResource(android.R.drawable.btn_default);
			a2.setTextColor(Color.BLACK);}

	}
	
	public void clickAnswer(View view) {
		
		Button click = (Button) view;
		String answer = click.getText().toString();
		int rightAns = list.get(nquest).getRight();


        if(answer.equals(list.get(nquest).getAnswer(rightAns-1))) {

					totalScore += score[nquest];

                    if(nquest == 4 || nquest == 9) {

                        secureScore = totalScore;
                        Toast.makeText(getApplicationContext(), "¡Zona Segura! Puntuación guardada", Toast.LENGTH_SHORT).show();
                    }

                    if(nquest == 14) {

                        saveScore(totalScore);
                        Toast.makeText(getApplicationContext(), "Enhorabuena.¡Has Ganado!", Toast.LENGTH_SHORT).show();

                        endGame();
                    }

					nquest++;

                setQuestions();
		}
        else{
            Toast.makeText(getApplicationContext(), "Fallaste! Vuelve a intentarlo ;)", Toast.LENGTH_SHORT).show();
            if(secureScore > 0)
                saveScore(secureScore);

            endGame();
        }



	}
	
	public void saveScore(int totalScore) {
		
		DBScores scoredb = new DBScores(this);
		
		SharedPreferences preferences = getSharedPreferences(SettingsActivity.PREF_NAME, Context.MODE_PRIVATE);		
		String user = preferences.getString("data","");
		
		Score score = new Score(user, totalScore);
		scoredb.addScore(score);
		
		
	}
	public void endGame() {

        deleteGameState();
		startActivity(new Intent(PlayActivity.this, MainActivity.class));
	
	}
    public void saveGameState() {

        SharedPreferences preferences = getSharedPreferences("state", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("numberQuestion", nquest);
        editor.commit();
    }

    public void restoreGameState() {

        SharedPreferences preferences = getSharedPreferences("state", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        nquest = preferences.getInt("numberQuestion",0);

        setQuestions();

    }
    public void deleteGameState() {

        SharedPreferences preferences = getSharedPreferences("state", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();



    }

    public void onDestroy() {
        super.onDestroy();
        saveGameState();
    }

    public void onStart() {
        super.onStart();
        restoreGameState();
    }
}



