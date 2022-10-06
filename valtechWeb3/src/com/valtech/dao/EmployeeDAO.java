package com.valtech.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class EmployeeDAO {
	
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static final String TABLE_NAME="v_employee";
	
	public int getNextValidId() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select max(id) from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		int id=-1;
		if(rs.next()) {
			id = rs.getInt(1);
			
		}
		con.close();
		return id+1;

	}
	
	public int getNextId(int currId) throws Exception {
		int id=-1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select id from "+TABLE_NAME+" where id >? fetch next 1 row only");
		ps.setInt(1,  currId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) id = rs.getInt(1);
		con.close();
		return id;
		
		
	}
	
	public int getMinId() throws Exception {
		int id=-1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(id) from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			id = rs.getInt(1);
			
		}
		con.close();
		return id;	
	}
	
	public int getMaxId() throws Exception {
		int id=-1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select max(id) from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			id = rs.getInt(1);
			
		}
		con.close();
		return id;	
	}
	
	
	public int getPreviousId(int currId) throws Exception {
		int id=-1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select id from "+TABLE_NAME+" where id <? fetch next 1 row only");
		ps.setInt(1,  currId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) id = rs.getInt(1);
		con.close();
		return id;
		
	}
	
	public void updateEmployee(Employee e) throws Exception  {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE "+TABLE_NAME+" set name=?, age=?, gender=?, salary=? where id=?");
		//Employee e =new Employee();
		ps.setInt(5,  e.getId());
		ps.setString(1,  e.getName());
		ps.setInt(2,  e.getAge());
		ps.setInt(3,  e.getGender());
		ps.setDouble(4, e.getSalary());
		
		ps.executeUpdate();
        con.close();	
	}
	
	public void deleteEmployee(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps =con.prepareStatement("delete from "+TABLE_NAME+" where id = ?");
		ps.setInt(1,  id);
		ps.executeUpdate();
		con.close();
	}
	
	public List<Employee> getEmployees() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps =con.prepareStatement("select id,name,age,gender,salary from "+TABLE_NAME);
		ResultSet rs =ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));
		
			
		}
		con.close();
		return employees;
		
		
	}
	
	
	public Employee getEmployee(int id)throws Exception {
		Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT id,name,age,gender,salary from " +TABLE_NAME+" where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Employee e = employeeFromResultSet(rs);
			conn.close();
			return e;
		}else {
			return null;
		}
		
		
	}

	private Employee employeeFromResultSet(ResultSet rs) throws SQLException {
		Employee e =new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setGender(rs.getInt(4));
		e.setSalary(rs.getFloat(5));
		return e;
	}		
		
	
	public void saveEmployee(Employee e) throws Exception {
		Connection con =getConnection();
		PreparedStatement ps = con.prepareStatement("insert into "+TABLE_NAME+ "(id,name,age,gender,salary) values(?,?,?,?,?)");
		ps.setInt(1,  e.getId());
		ps.setString(2,  e.getName());
		ps.setInt(3,  e.getAge());
		ps.setInt(4,  e.getGender());
		ps.setDouble(5,  e.getSalary());
		
		int rowsAffected =ps.executeUpdate();
        con.close();
	}
	
	//find by age
	public Employee findByAge(int age) throws Exception {
		Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT id,name,age,gender,salary from " +TABLE_NAME+" where age = ?");
		ps.setInt(1,  age); 
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Employee e = employeeFromResultSet(rs);
			conn.close();
			return e;
		}else {
			return null;
		}
		
		
	}
	
	//find between age
	public List<Employee> findBetweenAge(int min,int max) throws Exception {
		Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT * from " +TABLE_NAME+" where age BETWEEN (SELECT min(age) FROM " + TABLE_NAME + ") And (SELECT max(age) FROM " + TABLE_NAME + ")"); 
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		
		if(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
			conn.close();
			return employees;
		}
	
	//Find Salary greater
	public List<Employee> getEmployeesSalaryGreater(float salary)  throws Exception {
		Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT * from " +TABLE_NAME+ " where salary >= ?");
		ps.setDouble(1, salary);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		if(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
			conn.close();
			return employees;
		}
	  
	//Find Salary less than
	 public List<Employee> getEmployeesSalaryLesser(float salary)  throws Exception {
		Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT * from " +TABLE_NAME+ " where salary <= ?");
		ps.setDouble(1, salary);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		if(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
			conn.close();
			return employees;
		}
	 
	 //Find Male
	 public List<Employee> getEmpMale(int gender) throws Exception{
		 Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT * from " +TABLE_NAME+ " where gender = ?");
		ps.setInt(1,  gender); 
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		if(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
			conn.close();
			return employees;
		}
	 
	 //Find Female
	 public List<Employee> getEmpFemale(int gender) throws Exception{
		 Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT * from " +TABLE_NAME+ " where gender = ?");
		ps.setInt(1,  gender); 
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		if(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
			conn.close();
			return employees;
		}
	 
	 //find others
	 public List<Employee> getEmpOthers(int gender) throws Exception{
		 Connection conn=getConnection();
		PreparedStatement ps =conn.prepareStatement("SELECT * from " +TABLE_NAME+ " where gender = ?");
		ps.setInt(1,  gender); 
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		if(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
			conn.close();
			return employees;
		}
	 	
		
	public int count() throws Exception {
		Connection con =getConnection();
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery("Select count(id) from "+TABLE_NAME);
		if(rs.next()) {
			int count = rs.getInt(1);
			con.close();
			return count;
			
		}else {
			con.close();
			return -1;
		}
		
	}

	
	public Connection getConnection()throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.35:1521/xe","valtrg10","valtrg10");
		

}

}