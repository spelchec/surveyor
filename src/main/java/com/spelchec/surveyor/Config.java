package com.spelchec.surveyor;

import java.nio.file.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.vfs.VFS;
import org.jboss.vfs.VirtualFile;

public class Config {

	private final Logger logger = LogManager.getLogger(Config.class);
	private static Config config;
	private static Properties props;
	
	private Config() throws IOException, URISyntaxException {
		logger.warn("===============================");
		URL resource = Config.class.getResource("config.properties");
		if (resource == null) {
			throw new NullPointerException("Resource not found.");
		}
		URI f = resource.toURI();
		//f = fixUri(f);
		VirtualFile someFile = VFS.getChild(f);  
		logger.info("Loading VirtualFile location {}", someFile);
		props = new Properties();
//		Path p = Paths.get(f);
		InputStream in = null;
		// = new FileInputStream(.toFile());
		if(someFile.exists()) {  
		    in = someFile.openStream();  
		    // Do something with the stream  
		}  
		props.load(in);
	}
	
	public static Config build() throws IOException, URISyntaxException {
		if (null == config) {
			config = new Config();
		}
		return config;
	}
	
	public Object get(String key) throws IOException,URISyntaxException {
		return props.get(key);
	}
	
}
