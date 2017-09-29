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
	@Override
	String search(String text) throws Exception {
		String result = null;
		try {
			Connection connection = this.getConnection();
			//////////TODO////////
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT keyword, response FROM keywordresponsetable where keyword like concat('%',?,'%')");
			stmt.setString(1,text);
			////////////////////////
			ResultSet rs = stmt.executeQuery();
            
			while(rs.next()) {
				result = rs.getString(2);
			} //this can contain bugs
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
		if (result != null)	
			return result;
		throw new Exception("NOT FOUND");
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
