package ksu.chakravaram.client.DAO;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ksu.chakravaram.client.modelclasses.IntegerValue;
import ksu.chakravaram.client.modelclasses.ListPosts;
import ksu.chakravaram.client.modelclasses.ListProfiles;
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

public ListPosts viewPosts()
	
	{
		ListPosts m=null;
		Client client = Client.create();
		  
		  
		WebResource webResource = client
		   .resource("http://localhost:8081/WebServices_Final1/backend/profiles/allposts");

		ClientResponse res = webResource.accept("application/xml")
		           .get(ClientResponse.class);

		if (res.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ res.getStatus());
		}

		try{
			String output = res.getEntity(String.class);
			
			  
		JAXBContext context= JAXBContext.newInstance(ListPosts.class);
		

		Unmarshaller um=context.createUnmarshaller();
	

	 m= (ListPosts) um.unmarshal(new StringReader(output));


		}
		catch(Exception e)
		{
			System.out.println("exception"+e);
		}
		
		return m;

	}



public ListProfiles viewAllProfiles()

{
	ListProfiles m=null;
	Client client = Client.create();
	  
	  
	WebResource webResource = client
	   .resource("http://localhost:8081/WebServices_Final1/backend/profiles/allprofiles");

	ClientResponse res = webResource.accept("application/xml")
	           .get(ClientResponse.class);

	if (res.getStatus() != 200) {
	   throw new RuntimeException("Failed : HTTP error code : "
		+ res.getStatus());
	}

	try{
		String output = res.getEntity(String.class);
		
		  
	JAXBContext context= JAXBContext.newInstance(ListProfiles.class);
	

	Unmarshaller um=context.createUnmarshaller();


 m= (ListProfiles) um.unmarshal(new StringReader(output));


	}
	catch(Exception e)
	{
		System.out.println("exception in client listallprofiles"+e);
	}
	
	return m;

}



public int deleteProfile(int id)

{
  int m=0;
	Client client = Client.create();
	  System.out.println("deteting id "+id);
	  
	WebResource webResource = client
	   .resource("http://localhost:8081/WebServices_Final1/backend/profiles/delete/"+id);

	ClientResponse res = webResource.accept("application/xml")
	           .delete(ClientResponse.class);

	if (res.getStatus() != 200) {
	   throw new RuntimeException("Failed : HTTP error code : "
		+ res.getStatus());
	}

	try{
		String output = res.getEntity(String.class);
		
		  
	JAXBContext context= JAXBContext.newInstance(IntegerValue.class);
	

	Unmarshaller um=context.createUnmarshaller();


       IntegerValue iv= (IntegerValue) um.unmarshal(new StringReader(output));
       m=iv.getI();


	}
	catch(Exception e)
	{
		System.out.println("exception in client deleting"+e);
	}
	
	return m;

}
}
