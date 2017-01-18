package com.spelchec.surveyor.routing;

import java.io.ByteArrayOutputStream;
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

import com.esotericsoftware.yamlbeans.YamlReader;
import com.spelchec.surveyor.ByteArrayOutputStreamHelper;
import com.spelchec.surveyor.Config;
import com.spelchec.surveyor.model.Option;
import com.spelchec.surveyor.model.Question;
import com.spelchec.surveyor.model.Survey;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Path("/view")
public class View {
	@GET
	@Path("{id}")
	@Produces({ MediaType.TEXT_HTML })
	public String view(@PathParam("id") Integer id) throws IOException, URISyntaxException, TemplateException {
		InputStream is = null;
		try {
			Config config = Config.build();
		String fileLocation = config.get("location.root") + "questions" + id.toString() + ".yaml";
		java.nio.file.Path file = Paths.get(fileLocation);
		if (file.toFile().exists()) {
/*
		is = new FileInputStream(file.toFile());
		byte out;
		String outStr = "";
		while (0 <= (out = (byte) is.read())) {
			outStr += (char)out;
		}
		return outStr;

*/
			YamlReader yamlReader = new YamlReader(new FileReader(file.toFile()));
			yamlReader.getConfig().setPropertyElementType(Survey.class, "questions", Question.class);
			yamlReader.getConfig().setPropertyElementType(Question.class, "options", Option.class);
			Survey object = yamlReader.read(Survey.class);
			Template template = ApplicationConfig.cfg.getTemplate("survey.ftlh");
			
			Map<String, Object> rootModel = new HashMap<String, Object>();
			rootModel.put("survey", object);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Writer out = new OutputStreamWriter(baos);
			template.process(object, out);
			out.close();
			
			return ByteArrayOutputStreamHelper.convert(baos);
		} else {
			return null;
		}
		} finally {
			if (is != null) {
				is.close();
				
			}
		}
	}

}
