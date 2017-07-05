package com.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.css.factory.DbFactory;
import com.css.model.StudentVO;
public class StudentDAO {

	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;
	StudentVO studentVO;
	
	public StudentDAO(){
		dbFactory = new DbFactory();
		connection = dbFactory.getCon();
	}
	
	public int addStudent(StudentVO studentVO )
	{	

		try{
			preparedStatement = connection.prepareStatement("insert into css_student (student_name,student_email,student_password) values(?,?,?)");
			preparedStatement.setString(1,studentVO.getStudentName());
			preparedStatement.setString(2,studentVO.getStudentEmail());
			preparedStatement.setString(3,studentVO.getStudentPassword());
		
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
    public int getStudentId()
	{
		try
		{
			preparedStatement = connection.prepareStatement("select last_insert_id()");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				result = resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			dbFactory.closeCon();
		}
		return result;
	}

	
	public boolean authenticateStudent(String studentId,String studentPassword)
	{
		try{
		   try
		   {
		    int id=Integer.parseInt(studentId);
		    preparedStatement=connection.prepareStatement("Select * from css_student where student_id=? and student_password=?");
		   }
		   catch(NumberFormatException e)
		   {
			  preparedStatement=connection.prepareStatement("Select * from css_student where student_email=? and student_password=?");   
		   }
		    preparedStatement.setString(1,studentId);
		    preparedStatement.setString(2,studentPassword);
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
	
	public StudentVO searchStudent(String studentId){
		try{
			   try
			   {
			    int id=Integer.parseInt(studentId);
			    preparedStatement=connection.prepareStatement("Select * from css_student where student_id=?");
			   }
			   catch(NumberFormatException e)
			   {
				  preparedStatement=connection.prepareStatement("Select * from css_student where student_email=?");   
			   }
			    preparedStatement.setString(1,studentId);
			    resultSet=preparedStatement.executeQuery();
			    if(resultSet.next())
			    {
			    	studentVO = new StudentVO();
			    	studentVO.setStudentId(resultSet.getInt(1));
			    	studentVO.setStudentName(resultSet.getString(2)); 
			    	studentVO.setStudentEmail(resultSet.getString(4)); 
			    	studentVO.setStudentPassword(resultSet.getString(3)); 
			    	return studentVO;
 			    }
			    
			}
			catch(SQLException ab){
				System.out.println(ab);
			} 
			return null;	
	}
	
	public int deleteStudent(String studentId){
		try{
    		try{
    			int id = Integer.parseInt(studentId);
			    preparedStatement=connection.prepareStatement("delete from css_student where student_id=?");      			
    		}
    		catch(NumberFormatException e){
			    preparedStatement=connection.prepareStatement("delete from css_student where student_email=?");      			
    		}
    		preparedStatement.setString(1,studentId);
		    resultSet=preparedStatement.executeQuery();
		    if(resultSet.next())
		    	return 1;
    	}
    	catch(Exception ab){
    		System.out.println("ab");  
    	}
		return 0;
	}
	
	public int updateStudent(StudentVO studentVO )
	{	

		try{
			preparedStatement = connection.prepareStatement("update css_student set student_name=?,student_email=?,student_password=? where student_id=?");
			preparedStatement.setString(1,studentVO.getStudentName());
			preparedStatement.setString(2,studentVO.getStudentEmail());
			preparedStatement.setString(3,studentVO.getStudentPassword());
			preparedStatement.setInt(4, studentVO.getStudentId()); 

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
