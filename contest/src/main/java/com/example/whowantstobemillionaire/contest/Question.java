package com.example.whowantstobemillionaire.contest;

public class Question {

	String number = null;
	String text = null;
    String[] answers = new String[4];
	String right = null;
	String audience = null;
	String phone = null;
	String fifty1 = null;
	String fifty2= null;

	public Question() {
	}
	
	public Question(String number, String text, String answer1, String answer2, String answer3, String answer4, String right, String audience, String phone, String fifty1, String fifty2) {
		this.number = number;
		this.text = text;
		this.answers[0] = answer1;
		this.answers[1] = answer2;
		this.answers[2] = answer3;
		this.answers[3] = answer4;
		this.right = right;
		this.audience = audience;
		this.phone = phone;
		this.fifty1 = fifty1;
		this.fifty2= fifty2;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer(int ans) {
        return this.answers[ans];
	}

	public int getRight() {
		return Integer.parseInt(right);
	}

	public void setRight(String right) {
		this.right = right;
	}

	public int getAudience() {
		return Integer.parseInt(audience);
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public int getPhone() {
		return Integer.parseInt(phone);
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getFifty1() {
		return Integer.parseInt(fifty1);
	}

	public void setFifty1(String fifty1) {
		this.fifty1 = fifty1;
	}

	public int getFifty2() {
		return Integer.parseInt(fifty2);
	}

	public void setFifty2(String fifty2) {
		this.fifty2 = fifty2;
	}

	public int getNumber() {
		return Integer.parseInt(number);
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
