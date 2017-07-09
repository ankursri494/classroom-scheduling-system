package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.factory.DbFactory;
import com.css.model.TrainingProgramVO;


import java.sql.ResultSet;


public class TrainingProgramDAO {
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	Connection connection;
	int result;

	public TrainingProgramDAO() {
		dbFactory = new DbFactory();
		connection = dbFactory.getCon();
	}

	public int addTrainingProgram(TrainingProgramVO e) {
		try {
			preparedStatement = connection.prepareStatement("insert into css_training_program values(?,?,?,?,?)");
			preparedStatement.setInt(1, e.getTrainingId());
			preparedStatement.setString(2, e.getTrainingName());
			preparedStatement.setInt(3, e.getStudentIntake());
			preparedStatement.setInt(4, e.getTrainingDuration());
			preparedStatement.setString(5, e.getTrainingDescription());

			result = preparedStatement.executeUpdate();
			System.out.println("res=" + resultSet);
			if (result > 0) {
				connection.commit();
				dbFactory.closeCon();
			}
		}

		catch (SQLException ae) {
			System.out.println(ae);
		}
		return result;
	}


	public int updateTrainingProgram(TrainingProgramVO e){
		try{
			preparedStatement = connection.prepareStatement("update css_training_program set training_name =?,student_intake=?,training_duration=?,training_description=? where training_id= ?");
			preparedStatement.setString(1,e.getTrainingName());
			preparedStatement.setInt(2,e.getStudentIntake());
			preparedStatement.setInt(3,e.getTrainingDuration());
			preparedStatement.setString(4,e.getTrainingDescription());
			preparedStatement.setInt(5,e.getTrainingId());


			result=preparedStatement.executeUpdate();

			if(result>0)
			{connection.commit();
			dbFactory.closeCon();	}

		} catch (SQLException we) {
			// TODO Auto-generated catch block
			we.printStackTrace();
		}
		return result;

	}


	public int deleteTrainingProgram(TrainingProgramVO e){
		try{
			preparedStatement= connection.prepareStatement("delete from css_training_program where training_id = ? ");
			preparedStatement.setInt(1,e.getTrainingId());
			result=preparedStatement.executeUpdate();

			if(result>0)
			{connection.commit();
			dbFactory.closeCon();	}

		}catch(SQLException qw){
			System.out.println(qw);
		}return result;
	}
	ResultSet resultSet;
	TrainingProgramVO trainingProgramVO;

	public TrainingProgramVO searchTrainingProgram(int empId)
	{
		try{
			preparedStatement=connection.prepareStatement("Select * from css_training_program where training_id=?");
			preparedStatement.setInt(1,empId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				trainingProgramVO=new TrainingProgramVO();
				trainingProgramVO.setTrainingId(resultSet.getInt(1));
				trainingProgramVO.setTrainingName(resultSet.getString(2));
				trainingProgramVO.setStudentIntake(resultSet.getInt(3));
				trainingProgramVO.setTrainingDuration(resultSet.getInt(4));	
				trainingProgramVO.setTrainingDescription(resultSet.getString(5));
			}

		}
		catch(SQLException ab){
			System.out.println(ab);
		}return trainingProgramVO;
	}




	public List<TrainingProgramVO> displayAllTrainingProgram()
	{

		List<TrainingProgramVO> listTrainingProgram=new ArrayList<TrainingProgramVO>();

		try{
			preparedStatement=connection.prepareStatement("Select * from css_training_program");


			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				trainingProgramVO=new TrainingProgramVO();
				trainingProgramVO.setTrainingId(resultSet.getInt(1));
				trainingProgramVO.setTrainingName(resultSet.getString(2));
				trainingProgramVO.setStudentIntake(resultSet.getInt(3));
				trainingProgramVO.setTrainingDuration(resultSet.getInt(4));
				trainingProgramVO.setTrainingDescription(resultSet.getString(5));
				listTrainingProgram.add(trainingProgramVO);
			}
		}
		catch(SQLException ab){
			System.out.println(ab);
		}
		return listTrainingProgram;

	}
	

	/*public List<String> getAvailabletrainer(String training)
	{
		List<String> trainerList=new ArrayList<String>();


		try{
		    preparedStatement=connection.prepareStatement("select trainer_name from css_trainer where trainer_id in(select trainer_id from css_trainings_offered where training_id in (select training_id from css_training_program where training_name=?));");
		    preparedStatement.setString(1,training);
		    resultSet=preparedStatement.executeQuery();
		    while(resultSet.next())
		    {

		    	trainerList.add(resultSet.getString(1));

		    }

		}
		catch(SQLException ab){
			System.out.println(ab);
		}

		return trainerList;
	}	

}*/


	public HashMap<Integer,Integer> getAvailableTime(int trainerId, String day)
	{
		HashMap<Integer,Integer> timeList=new HashMap<Integer,Integer>();
		try{
			preparedStatement=connection.prepareStatement("Select * from css_trainer_schedule where trainer_id = ? and day = ?");
			preparedStatement.setInt(1,trainerId);
			preparedStatement.setString(2,day);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				timeList.put(1,resultSet.getInt(3));
				timeList.put(2,resultSet.getInt(4));
				timeList.put(3,resultSet.getInt(5));		    	
			}
			/*for(Map.Entry<Integer, Integer> entry:timeList.entrySet()){    
		        int key=entry.getKey();  
		        int b=entry.getValue();  
		        System.out.println(key + " " + b);
		    }*/ 
		}
		catch(SQLException ab){
			System.out.println(ab);
		}
		return timeList;
	}	


	public HashMap<Integer,String> getAvailabletrainer(String training)
	{
		HashMap<Integer,String> trainerList=new HashMap<Integer,String>();
		try{
			preparedStatement=connection.prepareStatement("select trainer_id,trainer_name from css_trainer where trainer_id in(select trainer_id from css_trainings_offered where training_id in (select training_id from css_training_program where training_name=?));");
			preparedStatement.setString(1,training);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
				trainerList.put(resultSet.getInt(1),resultSet.getString(2));		    
		}
		catch(SQLException ab){
			System.out.println(ab);
		}
		return trainerList;
	}


	public int scheduleTraining(String trainingName,int trainerId,String day,int time,int classId)
	{
		try
		{
			preparedStatement=connection.prepareStatement("select training_id from css_training_program where training_name=?");
			preparedStatement.setString(1,trainingName);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				connection.commit();
			int trainingId=resultSet.getInt(1);
			
			String timeSlot=Integer.toString(time);
			preparedStatement=connection.prepareStatement("Update css_classroom_availability set time_slot"+timeSlot+" =? where classroom_id=? and day=?");
			preparedStatement.setInt(1,trainingId);
			preparedStatement.setInt(2,classId);
			preparedStatement.setString(3,day);
			result=preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
			preparedStatement=connection.prepareStatement("Update css_trainer_schedule set time_slot"+timeSlot+" =? where trainer_id=? and day=?");
			preparedStatement.setInt(1,classId);
			preparedStatement.setInt(2,trainerId);
			preparedStatement.setString(3,day);
			result=preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
			preparedStatement=connection.prepareStatement("Insert into css_schedule (training_id,trainer_id,classroom_id,day,time) values (?,?,?,?,?)");
			preparedStatement.setInt(1,trainingId);
			preparedStatement.setInt(2,trainerId);
			preparedStatement.setInt(3,classId);
			preparedStatement.setString(4,day);
			preparedStatement.setInt(5,time);
			result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
			}
			}
		catch(SQLException ab)
			{
				System.out.println(ab);
			}
			return result;
	}
}