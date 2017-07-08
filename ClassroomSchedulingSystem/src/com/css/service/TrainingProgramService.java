package com.css.service;

import java.util.HashMap;
import java.util.List;

import com.css.dao.TrainingProgramDAO;
import com.css.model.TrainingProgramVO;

public class TrainingProgramService {

	
	TrainingProgramDAO trainingProgramDAO;

	public TrainingProgramService() {
		trainingProgramDAO=new TrainingProgramDAO();
	}
	
	public int addTrainingProgramService(TrainingProgramVO e)
	{
		return trainingProgramDAO.addTrainingProgram(e);
	}
	public int updateTrainingProgramService(TrainingProgramVO e)
	{
		return trainingProgramDAO.updateTrainingProgram(e);
	}
	
	public int deleteTrainingProgramService(TrainingProgramVO e)
	{
		return trainingProgramDAO.deleteTrainingProgram(e);
	}
	
	public List<TrainingProgramVO> displayAllTrainingProgramService()
	{
		return trainingProgramDAO.displayAllTrainingProgram();
	}
	
	
	public TrainingProgramVO searchTrainingProgramService(int TrainingId)
	{
 		return trainingProgramDAO.searchTrainingProgram(TrainingId);
	}
	
	public HashMap<Integer,String> getAvailabletrainerService(String training)
	{
		return trainingProgramDAO.getAvailabletrainer(training);
	}
	
	public HashMap<Integer,Integer> getAvailableTimeService(int trainerId, String day)
	{
		return trainingProgramDAO.getAvailableTime(trainerId, day);
	}
	
	public int scheduleTrainingService(String trainingName,int trainerId,String day,int time,int classId)
	{
		return trainingProgramDAO.scheduleTraining(trainingName,trainerId,day,time,classId);
	}

}
