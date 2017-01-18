package com.spelchec.surveyor;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamHelper {
	public static String convert(ByteArrayOutputStream baos) {
		StringBuilder sb = new StringBuilder();
		byte[] ba = baos.toByteArray();
		for (int k = 0; k < ba.length; k++) {
			sb.append((char)ba[k]);
		}
		return sb.toString();
	}
}
