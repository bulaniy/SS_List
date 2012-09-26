package Person;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

public class Test_Person_XML {

	Person_XML pd;
	
	@Before
	public void init() throws ClassNotFoundException, SQLException, FileNotFoundException{
     pd=  new Person_XML();
     pd.Connect();
     pd.DeleteAll();

	}
	
	@Test
	public void test_Connect() throws ClassNotFoundException, SQLException, FileNotFoundException {
	pd.Connect();
	}
	
	@Test
	public void test_Insert() throws ClassNotFoundException, SQLException, FileNotFoundException {
		Person per = new Person();
		per.setAge(20);
		per.setFname("GG");
		per.setLname("HH");
	    Person_XML p = new Person_XML();
	 
	    p.Create(per);
	    p.Create(per);
	    p.Create(per);
	    Person pp = p.Read().get(0);
		 assertEquals(pp, per);
	
	}

	@Test
	public void testToSt(){
		   Person p = new Person();
		   p.setAge(20);
		   p.setFname("Petr");
		   p.setLname("Ivanoff");
		   assertEquals("Petr,Ivanoff,20", p.toString());
	}
	
}
