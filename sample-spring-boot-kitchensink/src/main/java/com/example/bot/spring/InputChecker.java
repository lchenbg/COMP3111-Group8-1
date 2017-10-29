package com.example.bot.spring;
public class InputChecker {
	
	public boolean validName(String text) {
		return (text.length()<32);
	}
	public boolean validGender(String text) {
		return (Character.toUpperCase(text.charAt(0))=='M' ||Character.toUpperCase(text.charAt(0))=='F');
		}
	public boolean validHeight(String text) throws NumberFormatException {
		return( Double.parseDouble(text) < 260 && Double.parseDouble(text)> 50 );
	}
	public boolean validWeight(String text) throws NumberFormatException {
		return( Double.parseDouble(text) < 200 && Double.parseDouble(text)> 20 );
	}
	public boolean validAge(String text) throws NumberFormatException {
		return( Integer.parseInt(text) < 150 && Integer.parseInt(text)> 7 );
	}
	public boolean validExercise(String text) throws NumberFormatException {
		return(Integer.parseInt(text) < 16 && Integer.parseInt(text)>= 0);
	}
	public boolean validBodyfat(String text) throws NumberFormatException {
		return( Double.parseDouble(text) < 80 && Double.parseDouble(text)> 1);
	}
	public boolean validCalories(String text) throws NumberFormatException {
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
	}
	public boolean validOtherinfo(String text) throws NumberFormatException {
		return (text.length()<=1000);
	}
	
	
	public boolean ageEditting(String text, Users currentUser, SQLDatabaseEngine database, String mode) {
		try {
			if( validAge(text)) {
    			currentUser.setAge(Integer.parseInt(text)); 
    			switch(mode) {
    				case "set":database.pushUser(currentUser);break;
    				case "update" :database.updateUser(currentUser);break;
    				default:System.out.println("Mode error. Set failed.");
    			}
    			return true;
    			}
			else {
				return false;
			}
		}catch(NumberFormatException ne){return false;}
	}
}
