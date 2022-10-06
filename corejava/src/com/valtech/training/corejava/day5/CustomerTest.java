package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class CustomerTest {

	int Diamond=4;
	int Platinum =3;
	int gold=2;
	int silver=1;
	@Test
	public void test() throws Exception {
		
		Set<Customer> cust= new TreeSet<Customer>();
		
		Customer c1= new Customer("Varsha",Diamond,"2001-09-25",24000);
		Customer c2= new Customer("Aksh",Platinum,"2000-09-13",26000);
  	    Customer c3= new Customer("Varsh",Diamond,"2001-08-25",7400);
        Customer c4= new Customer("Ram",Platinum,"2001-09-10",54000);
        Customer c5= new Customer("Sita",gold,"2001-10-25",5400);
        Customer c6= new Customer("Sara",silver,"2001-10-25",5400);
       
        
		
		cust.add(c1);
		cust.add(c2);
  	    cust.add(c3);
  	    cust.add(c4);
  	    cust.add(c5);
  	    cust.add(c6);
  	   
  	    
  	    
		
		 System.out.println(cust.size());
		for(Customer c : cust) {
			System.out.println(c.name+" "+convert_to_string(c.type)+" "+c.date+" "+c.moneyspent);
		}
	
	}
	
	public String convert_to_string (int t1) {
		switch (t1) {
		case 1:
			  return "Silver";
		
		case 2:
			  return "Gold";
		
		case 3:
			  return "Paltinum";
			
		case 4:
			  return "Diamond";
			

		default:
			return "0";
		
		}
	}

}

