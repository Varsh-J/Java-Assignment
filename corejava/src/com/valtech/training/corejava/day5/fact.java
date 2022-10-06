package com.valtech.training.corejava.day5;

public class fact {
	public long fact(long n) {
		
		 if(n <= 1) {
	         return 1;
	      }
	      return n * fact(n - 1);
	   }
		
	
	public static void main(String[] args) {
		long n=0;
		fact ob = new fact();
		System.out.println(ob.fact(3));
		
	}

}
