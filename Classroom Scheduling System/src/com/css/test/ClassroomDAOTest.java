package com.css.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.css.model.ClassroomVO;
import com.css.service.ClassroomService;

public class ClassroomDAOTest {

	/*@Test
	public void testAddData() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateData() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchData() {
		fail("Not yet implemented");
	}
*/
	
	
	@Test
	public void testUpdateData() {
		ClassroomVO cls=new ClassroomVO();
		cls.setClassBlock("jla");
		cls.setClassFloor("465");
		cls.setClassCapacity("64856");
		cls.setClassId("45");
		assertEquals(1,new ClassroomService().updateDataService(cls));
		
	}
}
