package com.spelchec.surveyor;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {

	@Test
	public void test() throws IOException, URISyntaxException {
		Config config = Config.build();
		assertTrue("Dummy didn't load a value", null == config.get("dummy.mcdumdum"));
		assertTrue("Surveys loaded a value", null !=  config.get("location.root"));
	}
	
}
