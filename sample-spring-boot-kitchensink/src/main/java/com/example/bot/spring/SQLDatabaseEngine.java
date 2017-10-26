package com.example.bot.spring;

import lombok.extern.slf4j.Slf4j;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

@Slf4j
public class SQLDatabaseEngine extends DatabaseEngine {

	Users searchUser(String uidkey) throws Exception {
		String result[] = null;
		try {
			Connection connection = this.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT id FROM users WHERE id=sconcat(?)");
			stmt.setString(0,uidkey);
			ResultSet rs = stmt.executeQuery();
            
			while(rs.next()) {
				for(int i = 0 ; i <5 ; i++) result[i] = rs.getString(i);
			} //this can contain bugs
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
		if(result != null)	{
			Users getuser = new Users(result[0],result[1]);
			getuser.setGender(result[2].charAt(0));
			getuser.setHeight(Double.parseDouble(result[3]));
			getuser.setWeight(Double.parseDouble(result[4]));
			return getuser;
		}
		throw new Exception("NOT FOUND");
	}

	int pushUser(Users user) {
		String result = null;
		int row = 0;
		try {
			Connection connection = this.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO users VALUES concat(?,?,?,?,?)");
			stmt.setString(0, user.getID());
			stmt.setString(1, user.getName());
			String temp = ""+user.getGender();
			stmt.setString(2, temp) ;
			stmt.setString(3, String.valueOf(user.getHeight()));
			stmt.setString(4, String.valueOf(user.getWeight()));
		    row = stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		} 
		return row;
		
	}
	
	
	private Connection getConnection() throws URISyntaxException, SQLException {
		Connection connection;
		URI dbUri = new URI(System.getenv("DATABASE_URL"));//postgres://eazgxsrhxkhibl:69bfc6652d06407b34ffce5af54a478c07788cf800075f42c70e7e21fdde3630@ec2-107-22-187-21.compute-1.amazonaws.com:5432/ddqi3nebsahm4i
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() +  "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

		log.info("Username: {} Password: {}", username, password);
		log.info ("dbUrl: {}", dbUrl);
		
		connection = DriverManager.getConnection(dbUrl, username, password);

		return connection;
	}

}
