package org.shubham.javabrain.messenger.resources;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.shubham.javabrain.messenger.service.MessageService;


@Path("/messages")
public class MessageResource {
	
	
	MessageService messageservice = new MessageService();
	
	@POST
	@Path("/{message}/{too}")
	@Produces(MediaType.APPLICATION_XML)
	public String getallmess(@PathParam("message")String message,@PathParam("too")String too){
		return messageservice.getAllMessages(message,too);
	}
	
	
}
