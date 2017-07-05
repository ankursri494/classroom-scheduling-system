package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.css.factory.DbFactory;
import com.css.model.ClassroomVO;

public class ClassroomDAO {

	Connection connection;
	DbFactory db;
	PreparedStatement preparedStatement;
	int result;
	ResultSet resultSet;
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

}
