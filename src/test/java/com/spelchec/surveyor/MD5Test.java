package com.spelchec.surveyor;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MD5Test {

	@Test
	public void testHashing() throws NoSuchAlgorithmException {
		String result = MD5.toHash("Welcome!");
		System.out.println(result);
	}
	
}
