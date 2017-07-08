package com.css.model;

import java.util.ArrayList;

public class TrainerVO {
	String trainerName,trainerGender,trainerQualification,trainerEmail,trainerPassword;
	int trainerId,trainerAge;
	ArrayList<String> trainings;
	ArrayList<Integer> trainingsId;
	
	public ArrayList<String> getTrainings() {
		return trainings;
	}
	public void setTrainings(ArrayList<String> trainings) {
		this.trainings = trainings;
	}
	
	public ArrayList<Integer> getTrainingsId() {
		return trainingsId;
	}
	public void setTrainingsId(ArrayList<Integer> trainingsId) {
		this.trainingsId = trainingsId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainerGender() {
		return trainerGender;
	}
	public void setTrainerGender(String trainerGender) {
		this.trainerGender = trainerGender;
	}
	public String getTrainerQualification() {
		return trainerQualification;
	}
	public void setTrainerQualification(String trainerQualification) {
		this.trainerQualification = trainerQualification;
	}
	public String getTrainerEmail() {
		return trainerEmail;
	}
	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public int getTrainerAge() {
		return trainerAge;
	}
	public void setTrainerAge(int trainerAge) {
		this.trainerAge = trainerAge;
	}
	public String getTrainerPassword() {
		return trainerPassword;
	}
	public void setTrainerPassword(String trainerPassword) {
		this.trainerPassword = trainerPassword;
	}
}
