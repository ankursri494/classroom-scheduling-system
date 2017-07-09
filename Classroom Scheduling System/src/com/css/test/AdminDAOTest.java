package com.css.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.css.service.AdminService;


public class AdminDAOTest {

	@Test
	public void testAuthenticateAdmin() {
		assertTrue(new AdminService().authenticateAdminService("akanshasomya@gmail.com","akansha"));
	}

}
