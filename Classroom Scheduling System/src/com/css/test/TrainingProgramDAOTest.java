package com.css.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;



import org.junit.Test;
import com.css.service.TrainingProgramService;
import com.css.model.TrainingProgramVO;


public class TrainingProgramDAOTest {

	@Test
	public void testAddTrainingProgram() {
		
	
	TrainingProgramVO trainingProgramVO=new TrainingProgramVO();
	trainingProgramVO.setTrainingId(5);
	trainingProgramVO.setTrainingName("Aka");
	trainingProgramVO.setStudentIntake(21);
	trainingProgramVO.setTrainingDuration(20);
	trainingProgramVO.setTrainingDescription("xyz");
	
	assertEquals(1,new TrainingProgramService().addTrainingProgramService(trainingProgramVO));
	
	}
	
	@Test 
	public void testUpdateTrainingProgram() {
		TrainingProgramVO trainingProgramVO=new TrainingProgramVO();
		trainingProgramVO.setTrainingId(5);
		
		trainingProgramVO.setTrainingName("abc");
		trainingProgramVO.setStudentIntake(45);
		trainingProgramVO.setTrainingDuration(34);
		trainingProgramVO.setTrainingDescription("abc");
		
		assertEquals(1,new TrainingProgramService().updateTrainingProgramService(trainingProgramVO));
	}

	
	
	@Test
	public void testDeleteTrainingProgram() {
		TrainingProgramVO e=new TrainingProgramVO();
		e.setTrainingId(234);
		
		assertEquals(1,new TrainingProgramService().deleteTrainingProgramService(e));
	}
	
	
	@Test
	public void testSearchTrainingProgram() {
		//fail("Not yet implemented");
		assertNotNull(new TrainingProgramService().searchTrainingProgramService(5012));
		
	}
    
	@Test
	public void testDisplayAllTrainingProgram() {
		assertFalse(new TrainingProgramService().displayAllTrainingProgramService().isEmpty());
	}
    
	
}
