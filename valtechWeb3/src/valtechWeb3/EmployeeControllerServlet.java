package valtechWeb3;

import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

@WebServlet(urlPatterns = {"/empCtlr"})

public class EmployeeControllerServlet extends HttpServlet {
	
	
	private EmployeeDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao =new EmployeeDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submit = req.getParameter("submit");
		
		try {
		    if("New Employee".equals(submit)) {
		    	req.getRequestDispatcher("createEmp.jsp").forward(req,resp);
		    	return;
		    }
			if("Save".equals(submit)) {
				Employee e = new Employee();
				e.setId(dao.getNextValidId());
				e.setName(req.getParameter("name"));
                e.setAge(Integer.parseInt(req.getParameter("age")));
                e.setGender(Integer.parseInt(req.getParameter("gender")));
                e.setSalary(Float.parseFloat(req.getParameter("salary")));
                dao.saveEmployee(e);
			}
			
			if("Update".equals(submit)) {
				req.getRequestDispatcher("Update.jsp").forward(req,resp);
		    	return;	
			}
			
			if("Save_Update".equals(submit)) {
				Employee e = new Employee();
				e.setId(Integer.parseInt(req.getParameter("id")));
				e.setName(req.getParameter("name"));
                e.setAge(Integer.parseInt(req.getParameter("age")));
                e.setGender(Integer.parseInt(req.getParameter("gender")));
                e.setSalary(Float.parseFloat(req.getParameter("salary")));
                dao.updateEmployee(e);
				
			}
					
			req.setAttribute("emps",dao.getEmployees());
			req.getRequestDispatcher("Emps.jsp"). forward(req, resp);
		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
	}
	

	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login here and fwd to jsp page
		try {
		String empId = req.getParameter("empId"); 
		String submit = req.getParameter("submit");
		
		if(empId==null) {
			List<Employee> emps = dao.getEmployees();
			req.setAttribute("emps", emps);
			req.getRequestDispatcher("Emps.jsp").forward(req, resp);
			return;
		}
		int id = Integer.parseInt(req.getParameter("empId"));
		if("delete".equals(submit)) {
			dao.deleteEmployee(id);
			List<Employee> emps = dao.getEmployees();
			req.setAttribute("emps", emps);
			req.getRequestDispatcher("Emps.jsp").forward(req, resp);
			//return;
		}
			Employee e = dao.getEmployee(id);	
			req.setAttribute("e", e);
			req.getRequestDispatcher("Emp.jsp").forward(req, resp);
		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
		
	}
	
	

	
	
}
		
	


