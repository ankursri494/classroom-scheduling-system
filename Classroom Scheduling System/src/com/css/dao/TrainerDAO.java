package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.css.factory.DbFactory;
import com.css.model.TrainerVO;

public class TrainerDAO {
	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;
	TrainerVO trainerVO;
	
	public TrainerDAO(){
		dbFactory = new DbFactory();
		connection = dbFactory.getCon();

	}
	
	public int addTrainer(TrainerVO trainerVO)
	{	

		try{
			preparedStatement = connection.prepareStatement("insert into css_trainer (trainer_name,trainer_age,trainer_gender,trainer_qualification,trainer_email,trainer_password) values(?,?,?,?,?,?)");
			preparedStatement.setString(1,trainerVO.getTrainerName());
			preparedStatement.setInt(2, trainerVO.getTrainerAge());
			preparedStatement.setString(3, trainerVO.getTrainerGender());
			preparedStatement.setString(4, trainerVO.getTrainerQualification());
			preparedStatement.setString(5,trainerVO.getTrainerEmail());
			preparedStatement.setString(6,trainerVO.getTrainerPassword());
		
			result = preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
		}
		catch(SQLException e)
		{
			//System.out.println("DAO Exception");
			JOptionPane.showMessageDialog(null, "Email Id already Registered.!!");
		}
		return result;
	}
	public ArrayList<Integer> getTrainersTrainingsId(TrainerVO trainerVO){
		ArrayList<String> al;
		ArrayList<Integer> al2 = new ArrayList<Integer>();

		try{ 
			al = trainerVO.getTrainings();
			Iterator<String> itr = al.iterator();
			while(itr.hasNext()){
				preparedStatement = connection.prepareStatement("select training_id from css_training_program where training_name = ?");
				preparedStatement.setString(1, itr.next());
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
					al2.add(resultSet.getInt(1)); 
			}
		}
		catch(Exception e){
			System.out.println(e); 
		}
		finally{
		dbFactory.closeCon();
		}
		return al2;
	}
	
	public int addTrainersTrainings(TrainerVO trainerVO){
		ArrayList<Integer> al = trainerVO.getTrainingsId();
		Iterator<Integer> itr = al.iterator();
		try{
			while(itr.hasNext()){
				preparedStatement = connection.prepareStatement("insert into css_trainings_offered values(?,?)");
				preparedStatement.setInt(1, trainerVO.getTrainerId()); 
				preparedStatement.setInt(2, itr.next()); 
				result = preparedStatement.executeUpdate();
				if(result>0)
					connection.commit();
			}
		}
		catch(Exception e){
			System.out.println(e); 
		}
		return result;
	}
    public int getTrainerId()
	{
		try
		{
			preparedStatement = connection.prepareStatement("select last_insert_id()");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				result = resultSet.getInt(1);
				System.out.println(resultSet);

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return result;
	}
    
    public boolean authenticateTrainer(String trainerId, String trainerPassword){
    	try{
 		   try
 		   {
	 		    int id=Integer.parseInt(trainerId);
	 		    preparedStatement=connection.prepareStatement("Select * from css_trainer where trainer_id=? and trainer_password=?");
	 		    preparedStatement.setInt(1,id);
 		   }
 		   catch(NumberFormatException e)
 		   {
 			  preparedStatement=connection.prepareStatement("Select * from css_trainer where trainer_email=? and trainer_password=?");
 	 		  preparedStatement.setString(1,trainerId);
 		   }
 		   finally{
	 		    preparedStatement.setString(2,trainerPassword);
	 		    resultSet=preparedStatement.executeQuery();
	 		    if(resultSet.next())
	 		    {
	 		    	return true;	    	
	 		    }
 		   }
 		}
 		catch(SQLException ab){
 			System.out.println(ab);
 		} 
 		return false;
 		
 	}
    
    public TrainerVO searchTrainer(String trainerId){
		try{
			   try
			   {
			    int id=Integer.parseInt(trainerId);
			    preparedStatement=connection.prepareStatement("Select * from css_trainer where trainer_id=?");
			   }
			   catch(NumberFormatException e)
			   {
				  preparedStatement=connection.prepareStatement("Select * from css_trainer where trainer_email=?");   
			   }
			    preparedStatement.setString(1,trainerId);
			    resultSet=preparedStatement.executeQuery();
			    if(resultSet.next())
			    {
			    	trainerVO = new TrainerVO();
			    	trainerVO.setTrainerId(resultSet.getInt(1));  
			    	trainerVO.setTrainerName(resultSet.getString(2));  
			    	trainerVO.setTrainerAge(resultSet.getInt(3));  
			    	trainerVO.setTrainerGender(resultSet.getString(4));  
			    	trainerVO.setTrainerQualification(resultSet.getString(5));
			    	trainerVO.setTrainerEmail(resultSet.getString(6));
			    	trainerVO.setTrainerPassword(resultSet.getString(7));
			    	return trainerVO;
 			    }
			    
			}
			catch(SQLException ab){
				System.out.println(ab);
			} 
			return null;	
	}
    
    public int deleteTrainer(String trainerId){
    	try{
    		try{
    			int id = Integer.parseInt(trainerId);
			    preparedStatement=connection.prepareStatement("delete from css_trainer where trainer_id=?");      			
    		}
    		catch(NumberFormatException e){
			    preparedStatement=connection.prepareStatement("delete from css_trainer where trainer_email=?");      			
    		}
    		preparedStatement.setString(1,trainerId);
		    result=preparedStatement.executeUpdate();
		    if(result>0){
		    	connection.commit();
		    	return result;
		    }
    	}
    	catch(Exception ab){
    		System.out.println(ab);  
    	}
    	return 0;
    }

    
    public int updateTrainer(TrainerVO trainerVO)
	{	

		try{
			preparedStatement = connection.prepareStatement("update css_trainer set trainer_name=?,trainer_age=?,trainer_gender=?,trainer_qualification=?,trainer_password=? where trainer_email=?");
			preparedStatement.setString(1,trainerVO.getTrainerName());
			preparedStatement.setInt(2, trainerVO.getTrainerAge());
			preparedStatement.setString(3, trainerVO.getTrainerGender());
			preparedStatement.setString(4, trainerVO.getTrainerQualification());
			preparedStatement.setString(6,trainerVO.getTrainerEmail());
			preparedStatement.setString(5,trainerVO.getTrainerPassword());
			//preparedStatement.setInt(7, trainerVO.getTrainerId());
			result = preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
		}
		catch(SQLException e)
		{
			//System.out.println("DAO Exception");
			JOptionPane.showMessageDialog(null, "Email Id already Registered.!!");
		}
		finally{
			dbFactory.closeCon();
		}
		return result;
	}


}
