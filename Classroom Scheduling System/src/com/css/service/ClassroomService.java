package com.css.service;

import java.util.ArrayList;
import java.util.List;

import com.css.dao.ClassroomDAO;
import com.css.model.ClassroomAvailabilityVO;
import com.css.model.ClassroomVO;

public class ClassroomService {
	ClassroomDAO classroom;

	public ClassroomService(){
		classroom = new ClassroomDAO();
	}


	public int addDataService(ClassroomVO classData){
		return classroom.addData(classData);
	}
	
	public int updateDataService(ClassroomVO classData ){
		return classroom.updateData(classData);
	}
	
	public ClassroomVO searchDataService(String classId){
		return classroom.searchData(classId);
	}
	
	public int deleteDataService(ClassroomVO classData ){
		return classroom.deleteData(classData);
	}
	
	public ArrayList<ClassroomVO> viewDataService(){
		return classroom.viewData();
	}

	public int initializeClassAvailabilityService(String id){
		return classroom.initializeClassAvailability(id);
	}
	
	public ArrayList<Integer> getClassroomAvailabilityService(String day, int time){
		return classroom.getClassroomAvailability(day, time);
	}
	
	public List<ClassroomAvailabilityVO> getClassroomScheduleService(int classroom_id)
	{
		return classroom.getClassroomSchedule(classroom_id);
	}
}
