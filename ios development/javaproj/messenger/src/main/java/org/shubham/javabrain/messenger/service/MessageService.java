package org.shubham.javabrain.messenger.service;
import org.shubham.javabrain.messenger.database.DBConnect;
import org.shubham.javabrain.messenger.model.Message;

public class MessageService {
	
	

	
	public String getAllMessages(String message, String too){
		
		Message m1=new Message(message,too);
		DBConnect dcon = new DBConnect();
		String all = new String();
		dcon.putdata(m1);
		all=dcon.getdata();
		return all;
	
	}	
}
