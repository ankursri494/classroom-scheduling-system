package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.css.factory.DbFactory;
import com.css.model.ClassroomAvailabilityVO;
import com.css.model.ClassroomVO;

public class ClassroomDAO {

	Connection connection;
	DbFactory db;
	PreparedStatement preparedStatement,preparedStatement1;
	int result;
	ResultSet resultSet,resultSet1;
	ClassroomVO classDetails;

	public ClassroomDAO(){
		db = new DbFactory();
		connection = db.getCon();
	}

	public int addData(ClassroomVO classData){

		try{
			preparedStatement = connection.prepareStatement("insert into css_classroom values(?,?,?,?)");
			preparedStatement.setString(1,classData.getClassId());
			preparedStatement.setString(2,classData.getClassBlock());
			preparedStatement.setString(3,classData.getClassFloor());
			preparedStatement.setString(4,classData.getClassCapacity());
			result = preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return result;
	}

	public int initializeClassAvailability(String id){
		try{
			preparedStatement = connection.prepareStatement("insert into css_classroom_availability (classroom_id, day) values (?,'Monday')");
			preparedStatement.setString(1,id);
			result = preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("insert into css_classroom_availability (classroom_id, day) values (?,'Tuesday')");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("insert into css_classroom_availability (classroom_id, day) values (?,'Wednesday')");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("insert into css_classroom_availability (classroom_id, day) values (?,'Thursday')");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("insert into css_classroom_availability (classroom_id, day) values (?,'Friday')");
			preparedStatement.setString(1, id); 
			result = preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
		}
		catch(SQLException e){
			System.out.println(e);
		}
		finally{
			db.closeCon();
		}
		return result;
	}
	
	public int updateData(ClassroomVO classData){
		try{
			preparedStatement = connection.prepareStatement("update css_classroom set class_block=?, class_floor=?, class_capacity=? where classroom_id=?");

			preparedStatement.setString(1,classData.getClassBlock());
			preparedStatement.setString(2,classData.getClassFloor());
			preparedStatement.setString(3,classData.getClassCapacity());
			preparedStatement.setString(4,classData.getClassId());

			result = preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally{
			db.closeCon();
		}
		return result;
	}


	public ClassroomVO searchData(String classId){
		try{

			classDetails = new ClassroomVO();
			preparedStatement = connection.prepareStatement("select class_block,class_floor,class_capacity from css_classroom where classroom_id=?");
			preparedStatement.setString(1,classId);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next())
			{
				classDetails.setClassBlock(resultSet.getString(1));
				classDetails.setClassFloor(resultSet.getString(2));
				classDetails.setClassCapacity(resultSet.getString(3));
			}

		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally{
			db.closeCon();
		}
		return classDetails;
	}
	
	
	public int deleteData(ClassroomVO classData){
		try{
			preparedStatement = connection.prepareStatement("delete from css_classroom where classroom_id=?");
			preparedStatement.setString(1,classData.getClassId());
			result = preparedStatement.executeUpdate();
			if(result>0)
				connection.commit();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally{
			db.closeCon();
		}
		return result;
	}
	
	public ArrayList<ClassroomVO> viewData() {
		ArrayList<ClassroomVO> classrooms=new ArrayList<ClassroomVO>();
		try {
			preparedStatement = connection.prepareStatement("select * from css_classroom");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				classDetails = new ClassroomVO();
				classDetails.setClassId(resultSet.getString(1));
				classDetails.setClassBlock(resultSet.getString(2));
				classDetails.setClassFloor(resultSet.getString(3));
				classDetails.setClassCapacity(resultSet.getString(4));
				classrooms.add(classDetails);				
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally{
			db.closeCon();
		}
		return classrooms;
	}

	
	public ArrayList<Integer> getClassroomAvailability(String day,int time){
		ArrayList<Integer> classList = new ArrayList<Integer>();
		try{
		if(time == 1)	
			preparedStatement = connection.prepareStatement("select classroom_id from css_classroom_availability where day = ? and time_slot1 is null");
		else if(time ==2)
			preparedStatement = connection.prepareStatement("select classroom_id from css_classroom_availability where day = ? and time_slot2 is null");
		else
			preparedStatement = connection.prepareStatement("select classroom_id from css_classroom_availability where day = ? and time_slot3 is null");
		preparedStatement.setString(1, day);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			classList.add(resultSet.getInt(1));
		}
		}
		catch(Exception e){
			System.out.println();
		}
		return classList;
	}
	
	ClassroomAvailabilityVO classroomAvailabilityVO;
	public List<ClassroomAvailabilityVO> getClassroomSchedule(int classroom_id)
	{
		List<ClassroomAvailabilityVO> listTrainingProgram=new ArrayList<ClassroomAvailabilityVO>();
		try{
	preparedStatement=connection.prepareStatement("SELECT * from css_classroom_availability where classroom_id=? ORDER BY CASE WHEN day = 'Monday' THEN '1'WHEN day = 'Tuesday' THEN '2'WHEN day = 'Wednesday' THEN '3' WHEN day = 'Thursday' THEN '4' WHEN day = 'Friday' THEN '5' ELSE day END ASC");
	preparedStatement.setInt(1,classroom_id);
	resultSet=preparedStatement.executeQuery();
	while(resultSet.next())
	{
	classroomAvailabilityVO=new ClassroomAvailabilityVO();
	classroomAvailabilityVO.setClassroom_id(classroom_id);
	classroomAvailabilityVO.setDay(resultSet.getString(2));
	classroomAvailabilityVO.setTimeSlot1(resultSet.getInt(3));
	classroomAvailabilityVO.setTimeSlot2(resultSet.getInt(4));
	classroomAvailabilityVO.setTimeSlot3(resultSet.getInt(5));
	for(int i=1;i<=3;i++)
	{
	preparedStatement1=connection.prepareStatement("Select trainer_id from css_schedule where day=? and classroom_id=? and time=?");
	preparedStatement1.setString(1,resultSet.getString(2));
	preparedStatement1.setInt(2,classroom_id);
	preparedStatement1.setInt(3,i);
	resultSet1=preparedStatement1.executeQuery();
	while(resultSet1.next()) {
	if(i==1)
		classroomAvailabilityVO.setTrainer1(resultSet1.getInt(1)); 
	else if(i==2)
		classroomAvailabilityVO.setTrainer2(resultSet1.getInt(1)); 
	else
		classroomAvailabilityVO.setTrainer3(resultSet1.getInt(1)); }
	}
	listTrainingProgram.add(classroomAvailabilityVO);
	}
	}
	catch(SQLException ab){
	System.out.println(ab);
	}
	return listTrainingProgram;
	}

}
