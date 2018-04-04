package org.shubham.javabrain.messenger.database;

import java.sql.*;

import javax.xml.bind.annotation.XmlRootElement;

import org.shubham.javabrain.messenger.model.Message;


@XmlRootElement

public class DBConnect {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	 
	public DBConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test2","root","");
			st=con.createStatement();
			
		}catch (Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	String all=new String();
	public String getdata(){
		try{
			
			String query = "SELECT * FROM message ";
			rs =st.executeQuery(query);
			System.out.println("Records from database");
			while(rs.next()){
				String ipadress=rs.getString("ipadress");
				String too = rs.getString("too");
				String message = rs.getString("message");
				all = "'"+ipadress+"' , '"+too+"','"+message+"'";
			}
		System.out.println("finally got it");
			return  all;
		}catch(Exception ex){
			System.out.println(ex);
		}
		return null;
	}
	public void putdata(Message m){
		try{
			
		
		st=con.createStatement();
		
		String query ="INSERT INTO message VALUES ('"+m.ipadress+"' , '"+m.too+"','"+m.message+"')";
		st.execute(query);
		System.out.println("Inserting records into the table...");

		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
