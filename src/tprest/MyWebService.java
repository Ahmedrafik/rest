package tprest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/webs")
public class MyWebService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public String Hello(){
		return("hello !");
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/post")
	public String postMethod(@FormParam("name") String name){
		return("Hello Mr " + name);
	}
}
