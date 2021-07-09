package com.deepsingh44.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {

	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quotesdb", "root", "root");
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return connection;
	}

}
