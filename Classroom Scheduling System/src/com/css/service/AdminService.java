package com.css.service;

import com.css.dao.AdminDAO;
import com.css.dao.TrainerDAO;
import com.css.model.TrainerVO;

public class AdminService {
	AdminDAO adminDAO;
	
	public AdminService(){
		adminDAO = new AdminDAO();
	}
	
	public boolean authenticateAdminService(String trainerId, String Password){
		return adminDAO.authenticateAdmin(trainerId, Password);
	}


}
