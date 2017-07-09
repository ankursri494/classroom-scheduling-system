package com.css.service;

import java.util.ArrayList;
import java.util.List;

import com.css.dao.TrainerDAO;
import com.css.model.TrainerAvailabilityVO;
import com.css.model.TrainerVO;

public class TrainerService {
	
	TrainerDAO trainerDAO;
	
	public TrainerService(){
		trainerDAO = new TrainerDAO();
	}
	
	public int addTrainerService(TrainerVO trainerVO){
		return trainerDAO.addTrainer(trainerVO);
	}
	
	public int initializeTrainerScheduleService(int id){
		return trainerDAO.initializeTrainerSchedule(id);
	}
	
	public int updateTrainerService(TrainerVO trainerVO){
		return trainerDAO.updateTrainer(trainerVO);
	}
	
	public int getTrainerIdService(){
		return trainerDAO.getTrainerId();
	}
	
	public TrainerVO searchTrainer(String trainerId){
		return trainerDAO.searchTrainer(trainerId); 
	}
	
	public boolean authenticateTrainerService(String trainerId, String Password){
		return trainerDAO.authenticateTrainer(trainerId, Password);
	}
	
	 public int deleteTrainerService(String trainerId){
		 return trainerDAO.deleteTrainer(trainerId);
	 }
	 
	 public ArrayList<Integer> getTrainersTrainingsIdService(TrainerVO trainerVO){
		 return trainerDAO.getTrainersTrainingsId(trainerVO);
	 }
	 
	 public int addTrainersTrainingsService(TrainerVO trainerVO){
		 return trainerDAO.addTrainersTrainings(trainerVO);
	 }
	 
	 public List<TrainerAvailabilityVO> getTrainerScheduleService(int trainerId) 
	    {
		 return trainerDAO.getTrainerSchedule(trainerId);
	    }

}
