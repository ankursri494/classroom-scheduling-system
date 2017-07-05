package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.css.factory.DbFactory;
import com.css.model.TrainerVO;

public class AdminDAO {
	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;
	TrainerVO trainerVO;
	
	public AdminDAO(){
		dbFactory = new DbFactory();
		connection = dbFactory.getCon();

	}
	public boolean authenticateAdmin(String adminId,String adminPassword)
	{
		try{
		   try
		   {
		    int id=Integer.parseInt(adminId);
		    preparedStatement=connection.prepareStatement("Select * from css_admin where admin_id=? and admin_password=?");
		   }
		   catch(NumberFormatException e)
		   {
			  preparedStatement=connection.prepareStatement("Select * from css_admin where admin_email=? and admin_password=?");   
		   }
		    preparedStatement.setString(1,adminId);
		    preparedStatement.setString(2,adminPassword);
		    resultSet=preparedStatement.executeQuery();
		    if(resultSet.next())
		    {
		    	return true;	    	
		    }
		    
		}
		catch(SQLException ab){
			System.out.println(ab);
		} 
		return false;	
	}
}
