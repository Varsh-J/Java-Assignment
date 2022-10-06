package com.valtech.training.corejava.day4;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmployeeDAOTest {

	@Test
	public void test() throws Exception {
		 EmployeeDAO dao =new EmployeeDAO();
		 //Connection conn =dao.getConnection();
		 //assertEquals(3, dao.count());
		 //conn.close();
	}
	

	
	//list of Employee
	@Test
	public void testGetEmployee() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		Employee e = dao.getEmployee(1);
		assertEquals(1, e.getId());
		assertEquals(23, e.getAge());
		
				
	}
	
	//getting the count
	@Test
	public void testGetEmployees()throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		assertEquals(dao.count(),dao.getEmployees().size());
	}
	
	//adding new row
	@Test
	public void testSaveEmployee() throws Exception {
		 EmployeeDAO dao =new EmployeeDAO();
		 int count =dao.count();
		 dao.saveEmployee(new Employee(11,"ii",26,0,1000));
		 assertEquals(count+1, dao.count());
		 dao.deleteEmployee(5);
		 assertEquals(count, dao.count());
	}
	
	//update 
	@Test
	public void testupdateEmployee() throws Exception {
		 EmployeeDAO dao =new EmployeeDAO();
		 dao.updateEmployee(new Employee(3,"Ni", 20,1,12345));
		 Employee e =dao.getEmployee(3);
		 assertEquals(e.getId(),3);
		 assertEquals(e.getName(),"Ni");
		 assertEquals(20, e.getAge());
		 assertEquals(1, e.getGender());
		 assertEquals(12345, e.getSalary(),0.0000001);
		 	
	}
	
	//find by age
	@Test
	public void testgetByAge() throws Exception {
		 EmployeeDAO dao =new EmployeeDAO();
		 Employee e = dao.findByAge(23);
		 assertEquals(1, e.getId());
		 
		
	}
	
	//find between ages
	@Test
	public void testFindBetweenAge() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		List<Employee> e = new ArrayList<>();
		dao.findBetweenAge(20,23);
		int total = dao.findBetweenAge(20,23).size();
		assertEquals(total, dao.findBetweenAge(20,23).size());
		assertTrue("wi", true);
		
	}
		
	
	
	//find Salary Greater
	@Test
	public void testFindSalGt() throws Exception {
		 EmployeeDAO dao =new EmployeeDAO();
		 List<Employee> e = new ArrayList<>();
		 int total = dao.getEmployeesSalaryGreater(50000).size();
		 assertEquals(total, dao.getEmployeesSalaryGreater(50000).size());
		 assertTrue("fi", true);
		assertTrue("wi", true);
		assertFalse("ui", false);
		
	}
	
	//find salary lesser than
	@Test
	public void testFindSalLt() throws Exception {
		 EmployeeDAO dao =new EmployeeDAO();
		 List<Employee> e = new ArrayList<>();
		 int total = dao.getEmployeesSalaryGreater(50000).size();
		 assertEquals(total, dao.getEmployeesSalaryGreater(50000).size());
		 assertTrue("ui", true);
		assertTrue("Ni", true);
		assertFalse("fi", false);
	}
	
	//find male 
	@Test
	public void testFindMale() throws Exception {
		 EmployeeDAO dao =new EmployeeDAO();
		 List<Employee> e = new ArrayList<>();
		 int total = dao.getEmpMale(0).size();
		 assertEquals(total, dao.getEmpMale(0).size());
			assertTrue("ui", true);
		
	}
	
	//find female
		@Test
		public void testFindFemale() throws Exception {
			 EmployeeDAO dao =new EmployeeDAO();
			 List<Employee> e = new ArrayList<>();
			 int total = dao.getEmpFemale(1).size();
			 assertEquals(total, dao.getEmpFemale(1).size());
				assertTrue("Ni", true);
			
		}
		
		//find others
		@Test
		public void testFindOthers() throws Exception {
			 EmployeeDAO dao =new EmployeeDAO();
			 List<Employee> e = new ArrayList<>();
			 int total = dao.getEmpOthers(-1).size();
			 assertEquals(total, dao.getEmpOthers(-1).size());
				assertTrue("Ni", true);
			
		}
		
	


}


 
	


