package com.example.whowantstobemillionaire.contest;

public class Score {
	
	String _user;
	int _score;
	
	public Score() {
		
	}
	
	public Score(String user, int score) {
		this._user = user;
		this._score = score;
	}
	
	public String getUser() {
		return this._user;
	}
	
	public void setUser(String user) {
		this._user = user;
	}
	
	public int getScore() {
		return this._score;
	}
	
	public void setScore(int score) {
		this._score = score;
	}
}
