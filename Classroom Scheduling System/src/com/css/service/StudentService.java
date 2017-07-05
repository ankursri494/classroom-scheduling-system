package com.css.service;

import com.css.dao.StudentDAO;
import com.css.model.StudentVO;

public class StudentService {
		StudentDAO studentDAO;
		
		public StudentService() {
			// TODO Auto-generated constructor stub
			studentDAO = new StudentDAO();
		}
		
		public int  addStudentService(StudentVO studentVO) { 
			return studentDAO.addStudent(studentVO); 
		}
		public boolean authenticateStudentService(String studentId, String studentPassword){
			return studentDAO.authenticateStudent(studentId, studentPassword);
		}
		
		public int getStudentIdService(){
			return studentDAO.getStudentId();
		}
		
		public StudentVO searchStudent(String studentId){
			return studentDAO.searchStudent(studentId);
		}
}
