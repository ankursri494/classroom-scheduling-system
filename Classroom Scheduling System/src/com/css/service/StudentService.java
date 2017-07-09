package com.css.service;



import java.util.List;

import com.css.dao.StudentDAO;

import com.css.model.StudentVO;

public class StudentService {

	StudentDAO studentDAO;
	public StudentService()
	{
		studentDAO=new StudentDAO();
	}
	public int addStudentService(StudentVO studentVO)
	{
		return studentDAO.addStudent(studentVO);

		
	}
	public boolean authenticateStudentService(String studentId  ,String studentpassword )
	{
		return  studentDAO.authenticateStudent(studentId ,studentpassword);
		
	}
	
	
	public int updateStudentService(StudentVO studentvo) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(studentvo);
	}
	public int getStudentIdService() {
		
		return studentDAO.getStudentId();
	}
	
	
	public int deleteStudentService(int  studentId) {
		// TODO Auto-generated method stub
		return studentDAO.deleteStudent(studentId	);
	}
	public StudentVO searchStudentService(String studentId) {
		
		return studentDAO.searchStudent(studentId);
	}
	
	public List<StudentVO> displayAllStudentService()
	{
		return studentDAO.viewAllStudent();
	}
	
	
}
