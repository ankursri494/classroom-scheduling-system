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
		cls.setBlock("jla");
		cls.setFloor("465");
		cls.setCapacity("64856");
		cls.setID("45");
		assertEquals(1,new ClassroomService().updateDataService(cls));
		
	}
}
