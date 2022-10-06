package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class NumberSorterTest {
	
	@Test
	public void testCompare() {
		NumberSorter ns = new NumberSorter();
		assertEquals(-1, ns.compare(-1, 1));
	}

	
	@Test
	public void test() {
		Integer [] data= new Integer[] {57,32,46,71,1};
		Arrays.sort(data, new NumberSorter());
		assertArrayEquals(new Integer[] {1,57,71,46,32},data);
		assertArrayEquals(new Integer[] {-1,1,57,71,46,32},data);
	}


}
