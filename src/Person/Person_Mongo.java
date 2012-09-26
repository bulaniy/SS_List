package Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;


public class Person_Mongo
{
	private Connection connection;
	private DBCollection PersonCollection;
	
	public List<Person> Read() throws ClassNotFoundException, SQLException 
	{	
		ArrayList<Person> arr= new ArrayList<Person>();
	    DBCursor cursor = PersonCollection.find();
        while (cursor.hasNext()) {
            DBObject document = cursor.next();
            Person p = new Person();
            p.Id = (Integer) document.get("id");
            p.Fname = (String) document.get("Fname");
            p.Lname = (String) document.get("Lname");
            p.Age = (Integer) document.get("age");
            p.setNomer((String) document.get("nomer"));
            arr.add(p);        	     
        }    
        return arr;        
	}

	public void Create(Person p) throws SQLException, ClassNotFoundException
	{
		BasicDBObject document = new BasicDBObject();		
		document.put("id", p.Id);
        document.put("Fname", p.Fname);
        document.put("Lname", p.Lname);
        document.put("age", p.Age);
        document.put("nomer", p.getNomer());
        PersonCollection.insert(document);	
	}
	
	public void Update(Person p) throws SQLException, ClassNotFoundException
	{
	
	}
	
	public void Delete(Person p) throws SQLException, ClassNotFoundException
	{
	
	}
	
	public void DeleteAll() throws SQLException, ClassNotFoundException
	{
	
	}
	
	public void Connect() throws ClassNotFoundException, SQLException, UnknownHostException
	{
		
		    Mongo mongo = new Mongo();
	        DB db = mongo.getDB("SS");
	        PersonCollection = db.getCollection("person");
	        if (PersonCollection == null) {
	        	PersonCollection = db.createCollection("person", null);
	        }	
	}
	
	public void Disconnect() throws ClassNotFoundException, SQLException
	{
		connection.close();
	}

}
