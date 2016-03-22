package ksu.chakravaram.client.DAO;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ksu.chakravaram.client.modelclasses.Profiles;

public class DAO {

	public Profiles viewProfile(int id)
	
	{
		Profiles m=null;
		Client client = Client.create();
		  
		  
		WebResource webResource = client
		   .resource("http://localhost:8081/WebServices_Final1/backend/profiles/"+id);

		ClientResponse res = webResource.accept("application/xml")
		           .get(ClientResponse.class);

		if (res.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ res.getStatus());
		}

		try{
			String output = res.getEntity(String.class);
			
			  
		JAXBContext context= JAXBContext.newInstance(Profiles.class);
		

		Unmarshaller um=context.createUnmarshaller();
	

	 m= (Profiles) um.unmarshal(new StringReader(output));


		}
		catch(Exception e)
		{
			System.out.println("exception"+e);
		}
		
		return m;

	}
}
