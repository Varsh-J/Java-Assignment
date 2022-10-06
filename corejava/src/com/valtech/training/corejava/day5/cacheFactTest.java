package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class cacheFactTest {

	

	@Test
	public void test() {
		fact ob = new fact();
		assertEquals(6,ob.fact(3));
		
	}

}
