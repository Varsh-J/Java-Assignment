package com.valtech.training.corejava.day5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.valtech.training.corejava.day4.Employee;

public class cacheFact {
	
	List<Long> fact= new ArrayList<>();
	public Long fact(int n) {
		if(fact.size()>=(n-1)) {
			System.out.println("getting from cache");
			return fact.get(n-1);
		}
		
		if(n==1) {
			fact.add(1L);
			return (long) 1;
		}
		long factorial =fact(n-1);
		long factorialn=n* factorial;
		fact.add(factorialn);
		return factorialn;
	}
		
		
		
	public static void main(String[] args) {
	cacheFact ob = new cacheFact();
	System.out.println(ob.fact(2));
	}
	
}
