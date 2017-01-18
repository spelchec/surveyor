package com.spelchec.surveyor.routing;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/post")
public class Post {
	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String post(@FormParam("id") String id, @FormParam("q") String questions) {
		System.out.printf("%s; %s\n", id, questions);
		return null;
	}

	@GET
	public String post() {
		return "nope";
	}
}
