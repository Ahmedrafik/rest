package tprest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Path("/client")
public class ClientService {

	@GET
	@Path("/loc")
	public String localisation (@QueryParam("adress") String adress){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://maps.google.com/maps/api/geocode/json");
		target = target.queryParam("address", adress);
		Response res = target.request("text/plain").get();
		String str = res.readEntity(String.class);
		return str;
	}
	
	
	
	
	
}
