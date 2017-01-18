package com.spelchec.surveyor.model;

import org.junit.Test;

public class QuestionTest {
	@Test
	public void testQ() {
		Question q = new Question();
		q.setQuestion("Hello");
		System.out.println(q.getHashCode());
	}
}
