package com.css.service;

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
	
}
