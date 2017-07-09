package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.css.factory.DbFactory;
import com.css.model.ClassroomAvailabilityVO;
import com.css.model.DailyScheduleVO;
import com.css.model.TrainerVO;

public class AdminDAO {
	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement,preparedStatement1;
	ResultSet resultSet,resultSet1;
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
	
	DailyScheduleVO dailyScheduleVO;
	public List<DailyScheduleVO> getDailySchedule(String day)
	{
		List<DailyScheduleVO> dailySchedule = new ArrayList<DailyScheduleVO>();
		try
		{
			preparedStatement=connection.prepareStatement("SELECT classroom_id from css_classroom");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				dailyScheduleVO = new DailyScheduleVO();
				for(int i=1;i<=3;i++)
				{
					dailyScheduleVO.setClassId(resultSet.getInt(1));
					preparedStatement1=connection.prepareStatement("Select trainer_id,training_id from css_schedule where day=? and classroom_id=? and time=?");
					preparedStatement1.setString(1,day);
					preparedStatement1.setInt(2,resultSet.getInt(1));
					preparedStatement1.setInt(3,i);
					resultSet1=preparedStatement1.executeQuery();
					while(resultSet1.next()) 
					{
						if(i==1)
						{
							dailyScheduleVO.setTrainer1(resultSet1.getInt(1)); 
							dailyScheduleVO.setTraining1(resultSet1.getInt(2));
						}
						else if(i==2) 
						{
							dailyScheduleVO.setTrainer2(resultSet1.getInt(1)); 
							dailyScheduleVO.setTraining2(resultSet1.getInt(2));
						}
						else
						{
							dailyScheduleVO.setTrainer3(resultSet1.getInt(1)); 
							dailyScheduleVO.setTraining3(resultSet1.getInt(2));
						}
					}
				}
				dailySchedule.add(dailyScheduleVO);
			}
		}
		catch(SQLException ab){
		System.out.println(ab);
		}
		return dailySchedule;
	}

}
