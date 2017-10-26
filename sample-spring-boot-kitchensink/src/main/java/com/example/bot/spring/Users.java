package com.example.bot.spring;

public class Users {
	final private String UID;
	private String name;
	private char gender = 'M'; // this can be "M" or "F"
	private double weight = 0;
	private double height = 0;

	public Users(String UID, String name) {
		this.UID = UID;
		this.name = name;	
	}

	public boolean setName(String n) {this.name = n; return true;}	
	public boolean setGender(char g) {this.gender = g;return true;}
	public boolean setWeight(double w) {this.weight = w;return true;}
	public boolean setHeight(double h) {this.height = h;return true;}
	//assume inputs are always valid
	public String getID() {return UID;}
	public String getName() {return name;}	
	public char getGender() {return gender;}
	public double getWeight() {return weight;}
	public double getHeight() {return height;}

	
	@Override
	public String toString() { // this converts user to Json format
		return "\"name\":\"" + name + "\", "
				+"\"gender\":\"" + gender + "\", "
				+"\"weight\":\"" + weight + "\", "
				+"\"height\":\"" + height + "\" ";
	}

}
