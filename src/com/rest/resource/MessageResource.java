package com.rest.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.model.Message;
import com.service.MessageService;
@Path("messages")
public class MessageResource {
static MessageService service = new MessageService();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "REpresentation State Transfer";
	}
	
	@Path("/allmessages")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessage(){
		return service.getAllMessages();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message m) throws SQLException{
		return service.addMessage(m);
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message m){
		return service.updateMessage(m);
				
	}
	@Path("/{deleteId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("deleteId") long id){
		return service.removeMessage(id);
	}
	
	
}