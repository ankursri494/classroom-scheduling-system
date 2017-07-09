package com.css.service;

import java.util.List;

import com.css.dao.AdminDAO;
import com.css.dao.TrainerDAO;
import com.css.model.DailyScheduleVO;
import com.css.model.TrainerVO;

public class AdminService {
	AdminDAO adminDAO;
	
	public AdminService(){
		adminDAO = new AdminDAO();
	}
	
	public boolean authenticateAdminService(String trainerId, String Password){
		return adminDAO.authenticateAdmin(trainerId, Password);
	}

	public List<DailyScheduleVO> getDailyScheduleService(String day)
	{
		return adminDAO.getDailySchedule(day);
	}
}
