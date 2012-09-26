package Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Person_Dao
{
	private Connection connection;
	private PreparedStatement insert, select;

	public List<Person> Read() throws ClassNotFoundException, SQLException 
	{
	
		ArrayList<Person> arr= new ArrayList<Person>();
		select = connection.prepareStatement("select * from Person left join nomer on nomer.id_person=person.id");
		ResultSet rs = select.executeQuery();
		 while (rs.next()) {
			 Person p = new Person();
			 p.Id=Integer.parseInt(rs.getString(1));
		     p.Fname=rs.getString(2);
		     p.Lname=rs.getString(3);
		     p.Age  =Integer.parseInt(rs.getString(4)); 
		     p.setNomer(rs.getString(5));
		     arr.add(p);
		    }
		return arr;
	}

	public void Create(Person p) throws SQLException, ClassNotFoundException
	{
		select = connection.prepareStatement("insert into Person (id, Fname, Lname , age)"+
				"values (next value for seq_base, '"+p.Fname+"','"+p.Lname+"',"+p.Age+")");
		select.execute();
		select = connection.prepareStatement("insert into Nomer (id, id_person, nomer, )"+
				"values (next value for seq_base, seq_base.currval','"+p.getNomer()+")");
		select.execute();
	}
	
	public void Update(Person p) throws SQLException, ClassNotFoundException
	{
		select = connection.prepareStatement("update Person set Fname='"+p.Fname+"', Lname='"+p.Lname+"', age='"+p.Age+"'" +
				"where id="+p.Id+"");
		select.executeUpdate();
		select = connection.prepareStatement("update Nomer set nomer='"+p.getNomer()+"'where id_person="+p.Id+"");
		select.executeUpdate();
	}
	
	public void Delete(Person p) throws SQLException, ClassNotFoundException
	{
		select = connection.prepareStatement("delete from  Person where Id="+p.Id+"");
		select.executeUpdate();
	}
	
	public void DeleteAll() throws SQLException, ClassNotFoundException
	{
		select = connection.prepareStatement("delete from  Person");
		select.executeUpdate();
	}
	
	public void Connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.h2.Driver");
		connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
	}
	
	public void Disconnect() throws ClassNotFoundException, SQLException
	{
		connection.close();
	}

}
