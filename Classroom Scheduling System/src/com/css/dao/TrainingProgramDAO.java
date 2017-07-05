package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	             
	
	
}
