package com.spelchec.surveyor.routing;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.spelchec.surveyor.ByteArrayOutputStreamHelper;
import com.spelchec.surveyor.Config;
import com.spelchec.surveyor.model.Option;
import com.spelchec.surveyor.model.Question;
import com.spelchec.surveyor.model.Survey;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Path("/html")
public class Html {

	Logger logger = LogManager.getLogger(Html.class);

	@GET
	@Produces({MediaType.TEXT_HTML})
	@Path("/{location}")
	public InputStream viewHome(@PathParam("location") String location) throws FileNotFoundException
	{
	   File f = new File("C:\\Users\\Thomas\\Documents\\My Programs\\Surveyor\\survey\\"+location);
	   logger.info("Filepath: " + f.getAbsolutePath());
//	   return null;
	   return new FileInputStream(f);
	}


}
