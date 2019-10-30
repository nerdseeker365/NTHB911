package com.nt.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.dao.OneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOFactory;
import com.nt.entity.License;

public class AppTest {
       private static OneToOneFKDAO dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao=OneToOneFKDAOFactory.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao=null;
	}

	@Test
	public void saveDataUsingChild() {
		int expResult=1012;
		int actualResult=dao.saveDataUsingChild();
		assertEquals("test1", actualResult,expResult);
	}
	
	@Test
	public void loadDataUsingChild() {
		List<License> list=null;
		list=dao.loadDataUsingChild();
		//assertNotNull(list);
		assertTrue("test2",list.size()!=0);
	}

}
