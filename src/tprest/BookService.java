package tprest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/books")
public class BookService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/serial")
	public String bookSerialisationGet(@DefaultValue("25")  @QueryParam("id") String id) throws JsonProcessingException{
		Book book = new Book("Zootopia", Integer.parseInt(id), "k45ljh25m");
		String myBook = new ObjectMapper().writeValueAsString(book);
		return myBook;
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/serialpost")
	public String bookSerialisationPost(@DefaultValue("25")  @FormParam("id") String id) throws JsonProcessingException{
		Book book = new Book("Zootopia", Integer.parseInt(id), "k45ljh25m");
		String myBook = new ObjectMapper().writeValueAsString(book);
		return myBook;
	}
}
