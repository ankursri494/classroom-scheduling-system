package com.css.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbFactory {
	Connection connection;

	public Connection getCon(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_scheduling_system","root","akki1234");
			connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return connection;
	}
	public void closeCon(){
		try{
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
