package org.shubham.javabrain.messenger.model;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement//to convert to XML format
public class Message  {

	
	public String message;
	public InetAddress addr;
	{
		try {
        this.setAddr(InetAddress.getLocalHost());
    } catch (UnknownHostException e) {
        throw new InstantiationError("cannot find hub ip");
    }
		}
	public String ipadress = addr.getHostAddress();
 
	 public String too;
	
	public Message(){
	}
	
	/*	
	 * Constructor below allows to create instances 
	 */
	public Message(String message,String too){
		this.too=too;
		this.ipadress=addr.getHostAddress();
		this.message=message;
	}
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public InetAddress getAddr() {
		return addr;
	}

	public void setAddr(InetAddress addr) {
		this.addr = addr;
	}
	
	

		public String getIpadress() {
		return ipadress;
	}

	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}

		public String getToo() {
			return too;
		}

		public void setToo(String too) {
			this.too = too;
		}

	
		

}
