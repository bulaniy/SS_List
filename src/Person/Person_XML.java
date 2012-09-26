package Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Person_XML
{
	private Connection connection;
	
	public List<Person> Read() throws ClassNotFoundException, SQLException, FileNotFoundException
	{	
		XMLDecoder d = new XMLDecoder(new FileInputStream(new File("d:\\Person.xml")));
		ArrayList<Person> arr= new ArrayList<Person>();
		arr= (ArrayList<Person>) d.readObject();
		return arr;
	}

	public void Create(ArrayList<Person> p) throws SQLException, ClassNotFoundException, FileNotFoundException
	{
		XMLEncoder d= Connect();
		d.writeObject(p);
		d.close();
	}
	
	public void Update(Person p) throws SQLException, ClassNotFoundException, FileNotFoundException
	{
		XMLDecoder d = new XMLDecoder(new FileInputStream(new File("d:\\Person.xml")));
		ArrayList<Person> arr= new ArrayList<Person>();
		arr= (ArrayList<Person>) d.readObject();
		for (int i=0; i<arr.size();i++){
			Person per = arr.get(i);
		if (per.getId().equals(p.getId()))
		{
			per.setAge(p.getAge());
		    per.setFname(p.getFname());
		    per.setLname(p.getLname());
		    arr.set(i, per);
		    XMLEncoder d1= Connect();
			d1.writeObject(arr);
			d1.close();
		}	
		}	
	}
	
	public void Delete(Person p) throws SQLException, ClassNotFoundException, FileNotFoundException
	{
		XMLDecoder d = new XMLDecoder(new FileInputStream(new File("d:\\Person.xml")));
		ArrayList<Person> arr= new ArrayList<Person>();
		arr= (ArrayList<Person>) d.readObject();
		for (int i=0; i<arr.size();i++){
			Person per = arr.get(i);
		if (per.getId().equals(p.getId()))
		{
		    arr.remove(i);
		    XMLEncoder d1= Connect();
			d1.writeObject(arr);
			d1.close();
		}	
		}	
	}
	
	public void DeleteAll() throws SQLException, ClassNotFoundException
	{

	}
	
	public XMLEncoder Connect() throws ClassNotFoundException, SQLException, FileNotFoundException
	{
		 XMLEncoder d = new XMLEncoder(new FileOutputStream(new File ("d:\\Person.xml")));
		 return d;
	}
	
	public void Disconnect() throws ClassNotFoundException, SQLException
	{
		
	}

}
