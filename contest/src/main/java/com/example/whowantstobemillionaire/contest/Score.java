package com.example.whowantstobemillionaire.contest;

public class Score implements Comparable<Score>{
	
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

    public int compareTo(Score o) {
        // TODO Auto-generated method stub
        if (this.getScore() > o.getScore()) {
            return 1;
        }
        else if (this.getScore() < o.getScore()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
