package tprest;

import java.io.StringWriter;
import java.net.URI;
import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Path("/japx")
public class JAPXService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/book/{id}")
	public Book bookGetXLM(@DefaultValue("25") @PathParam("id") String id) throws JAXBException {
		Book book = new Book("Zootopia", Integer.parseInt(id), "k45ljh25m");
		return book;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/serialstring")
	public String bookGetXLMString(@DefaultValue("25") @QueryParam("id") String id) throws JAXBException {
		Book book = new Book("Zootopia", Integer.parseInt(id), "k45ljh25m");

		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(book, writer);
		return writer.toString();
	}

	@GET
	@Path("/book/rub-{rubrique}-sec-{section}")
	public String bookGetsection(@PathParam("rubrique") String rub, @PathParam("section") String sec)
			throws JAXBException {
		String result = "Ceci est le contenu de la rubrique " + Integer.parseInt(rub) + " et de la section "
				+ Integer.parseInt(sec);
		return result;
	}

	@GET
	@Path("/book/isbn/{isbn}")
	public String bookGetByIsbn(@PathParam("isbn") String isbn) throws JAXBException {
		String result = null;
		if (Pattern.matches("[0-9]*", isbn)) {
			result = "L'isbn est valide !";
		} else {
			result = "L'isbn n'est pas valide !";
		}
		return result;
	}

	@GET
	@Path("/book/date/{year}/{month}/{day}")
	public Response bookGetByDate(@PathParam("year") String year, @PathParam("month") String month,
			@PathParam("day") String day) throws JAXBException {
		String date = day + "-" + month + "-" + year;
		return Response.status(200).entity("Nous sommes le : " + date).build();
	}

	@GET
	@Path("/book/date")
	public Response bookGetByDateQuery(@QueryParam("year") String year, @QueryParam("month") String month,
			@QueryParam("day") String day) throws JAXBException {
		String date = day + "-" + month + "-" + year;
		return Response.status(200).entity("Nous sommes le : " + date).build();
	}

	@GET
	@Path("/book/dateMatrix")
	public Response bookGetByDateMatrix(@MatrixParam("year") String year, @MatrixParam("month") String month,
			@MatrixParam("day") String day) throws JAXBException {
		String date = day + "-" + month + "-" + year;
		return Response.status(200)
				.entity("Nous sommes le : " + date)
				.build();
	}

	@GET
	@Path("/def")
	public Response bookDef(@DefaultValue("1234567") @QueryParam("isbn") int isbn, @QueryParam("id") int id,
			@DefaultValue("date") @QueryParam("orderBy") List<String> orderBy) throws JAXBException {
		return Response.status(200)
				.entity("[ isbn = " + isbn + ", id = " + id + ", trie : " + orderBy + " ]")
				.build();
	}

	@GET
	@Path("/url")
	public Response getURL(@Context UriInfo ui) throws JAXBException {
		URI path = ui.getAbsolutePath();
		MultivaluedMap<String, String> params = ui.getQueryParameters();
		String path2 = ui.getPath();
		return Response.status(200)
				.entity("Absolute path : " + path.toString() + params.toString() + "\n"+ "Path : " + path2)
				.build();
	}
}
