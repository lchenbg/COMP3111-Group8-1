package com.example.bot.spring;

public class Users {
	final private String UID;
	private String name;
	private char gender = 'M'; // this can be "M" or "F"
	private int weight = 0;
	private int height = 0;
	private int bodyFat= 0 ;
	
	public Users(String UID, String name) {
		this.UID = UID;
		this.name = name;	
	}

	public boolean setName(String n) {this.name = n; return true;}	
	public boolean setGender(char g) {this.gender = g;return true;}
	public boolean setWeight(int w) {this.weight = w;return true;}
	public boolean setHeight(int h) {this.height = h;return true;}
	public boolean setBodyfat(int bf) {this.bodyFat = bf;return true;}
	//assume inputs are always valid
	public String getID() {return UID;}
	public String getName() {return name;}	
	public char getGender() {return gender;}
	public int getWeight() {return weight;}
	public int getHeight() {return height;}
	public int getBodyfat() {return bodyFat;}
	
	@Override
	public String toString() { // this converts user to Json format
		return "\"name\":\"" + name + "\", "
				+"\"gender\":\"" + gender + "\", "
				+"\"weight\":\"" + weight + "\", "
				+"\"height\":\"" + height + "\", "
				+"\"bodyfat\":\"" + bodyFat + "\" ";
	}
	
	
	public static void main(String [] args) {
		Users u = new Users("20308367","Charles");
		System.out.println(u);
	}
	
}
