package com.linecorp.bot.model.message;

public class InputChecker {

	public boolean validName(String text) {
		
	}
	public boolean validGender(String text) {}
	public boolean validHeight(String text) throws NumberFormatException {
		
	}
	public boolean validWeight(String text) throws NumberFormatException {
	}
	public boolean validAge(String text) throws NumberFormatException {
	}
	public boolean validExercise(String text) throws NumberFormatException {
	}
	public boolean validBodyfat(String text) throws NumberFormatException {
		return( Double.parseDouble(text) < 80 && Double.parseDouble(text)> 1);
	}
	public boolean validCaloriesString text) throws NumberFormatException {
		return( Integer.parseInt(text) < 15000 && Integer.parseInt(text)> 0 );
	}
	public boolean validCarbs(String text) throws NumberFormatException {
		return( Double.parseDouble(text) < 3000 && Double.parseDouble(text)> 0 ) ;
	}
	public boolean validProtein(String text) throws NumberFormatException {
		return( Double.parseDouble(text) < 1000 && Double.parseDouble(text)> 0 );
	}
	public boolean validVegfruit(String text) throws NumberFormatException {
		return( Double.parseDouble(text) < 50 && Double.parseDouble(text)> 0 );

	public boolean validOtherinfo(String text) throws NumberFormatException {
	}
}
