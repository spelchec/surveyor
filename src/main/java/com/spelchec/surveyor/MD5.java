package com.spelchec.surveyor;

import java.security.*;
import java.math.*;

public class MD5 {
	public static String toHash(String str) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(str.getBytes(),0,str.length());
		String returnString = new BigInteger(1,m.digest()).toString(16);
		return returnString;
	}
}
