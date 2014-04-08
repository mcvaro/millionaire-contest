package com.example.whowantstobemillionaire.contest;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBScores extends SQLiteOpenHelper {

	
	public DBScores(Context contexto) {
		 	super(contexto, "scores.db", null, 1)
		 	;
}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String sqlCreate = "CREATE TABLE Scores (id INTEGER PRIMARY KEY AUTOINCREMENT, user  TEXT NOT NULL, score INTEGER NOT NULL)";
		db.execSQL(sqlCreate);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		db.execSQL("DROP TABLE IF EXISTS Scores");
		
		onCreate(db);

		
	}
    public void delete(Context contexto) {
        contexto.deleteDatabase("Scores");
    }
	
	public void addScore(Score score) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("user", score.getUser()); 
		values.put("score", score.getScore());  
		         
	          
		db.insert("Scores", null, values);
	    db.close(); 
	}
	
	public List<Score> getAllScores() {
		
		List<Score> scoreList = new ArrayList<Score>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM Scores";
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            Score score = new Score();
	            score.setUser(cursor.getString(1));
	            score.setScore(Integer.parseInt(cursor.getString(2)));
	            
	            // Adding contact to list
	            scoreList.add(score);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return scoreList;
		
	}
	
	


	

}
