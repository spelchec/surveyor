package com.spelchec.surveyor.routing;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.spelchec.surveyor.Config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {
	
	public static Configuration cfg;
	
	static {
		
		String fileLocation = "";
		Config config;
		try {
			config = Config.build();
			fileLocation = config.get("location.freemarker").toString();

			// Create your Configuration instance, and specify if up to what FreeMarker
			// version (here 2.3.25) do you want to apply the fixes that are not 100%
			// backward-compatible. See the Configuration JavaDoc for details.
			cfg = new Configuration(Configuration.VERSION_2_3_25);
	
			// Specify the source where the template files come from. Here I set a
			// plain directory for it, but non-file-system sources are possible too:
			cfg.setDirectoryForTemplateLoading(new File(fileLocation));
	
			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");
	
			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	
			// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
			cfg.setLogTemplateExceptions(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}