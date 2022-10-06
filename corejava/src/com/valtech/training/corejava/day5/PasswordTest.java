package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PasswordTest {

	public void testlowercase() {
		Password pes= new Password();
		assertEquals(true,pes.islower("hijkl"));
		
		
	}
	@Test
	public void testUppercase() {
		Password pes= new Password();
		assertEquals(true,pes.isupper("LMNOP"));
		
		
	}


	@Test
	public void testdigitStrength() {
		Password pes= new Password();
		assertEquals(9,pes.checkdigit("34567"));
		
		
	}
	
	@Test
	public void testSpecislStrength() {
		Password pes= new Password();
		assertEquals(15,pes.checkspecialchar("!#%&^*"));
		
		
	}
	@Test
	public void testPasswordStrength() {
		Password pes= new Password();
		assertEquals("Moderate",pes.passwordStrengthChecker("Aksh@654"));
		assertEquals("Strong",pes.passwordStrengthChecker("Varsh.J@16597"));
		assertEquals("Characters is less than 8",pes.passwordStrengthChecker("Varsh"));
		assertEquals("weak",pes.passwordStrengthChecker("Varsha213"));
		
		
	}

}
