package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StringSortTest {

	
	@Test
  public void testLength() {
      String [] s1 = {"hii","hello","fifth","my"};
      Arrays.sort(s1, new StringSort());
      assertArrayEquals(new String[] {"my","hii","hello","fifth"},s1);
      
  }

  @Test
  public void testVowelCount() {
      String [] s1 = {"Abc","Lmno","Too","Ab","z"};
      Arrays.sort(s1, new StringSort());
      assertArrayEquals(new String[] {"z","Ab","Abc","Too","Lmno"}, s1);
      
  }
  @Test
  public void testAlphabeticOrder() {
      String[] names = { "Abc", "Lmno", "Too", "Ab", "z" };
      Arrays.sort(names, new StringSort());
      assertArrayEquals(new String[] { "z", "Ab","Abc", "Too", "Lmno" }, names);

}
}