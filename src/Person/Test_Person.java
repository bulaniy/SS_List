package Person;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

public class Test_Person {

	//Person_Dao pd;
	Person_Mongo pd;
	
	@Before
	public void init() throws ClassNotFoundException, SQLException, UnknownHostException{
     //pd=  new Person_Dao();
	 pd = new Person_Mongo();
     pd.Connect();
     pd.DeleteAll();

	}
	
	@Test
	public void test_Connect() throws ClassNotFoundException, SQLException, UnknownHostException {
	pd.Connect();
	}
	
	@Test
	public void test_Insert() throws ClassNotFoundException, SQLException {
    Person p = new Person();
    p.setAge(10);
    p.setLname("GG");
    p.setFname("Max");
    pd.Create(p);
    Person per =  pd.Read().get(0);
    assertEquals(p.Fname, per.Fname);
   // assertEquals(1, pd.Read().size());
    //pd.Disconnect();
	}

	@Test
	public void test_Delete() throws ClassNotFoundException, SQLException, UnknownHostException {
    Person p = new Person();
    p.setAge(10);
    p.setLname("GG1");
    p.setFname("Max2");
    pd.Create(p);
    Person per = pd.Read().get(0);
    assertEquals(p.Fname, per.Fname);
    pd.Disconnect();
    
    pd.Connect();
    Person pdel=pd.Read().get(0);
    pd.Delete(pdel);
    assertEquals(0, pd.Read().size());
    pd.Disconnect();
	}
	
	
	@Test
	public void test_Update() throws ClassNotFoundException, SQLException, UnknownHostException {
    Person p = new Person();
    p.setAge(10);
    p.setLname("GG1");
    p.setFname("Max2");
    pd.Create(p);
    Person per = pd.Read().get(0);
    assertEquals(p.Fname, per.Fname);
    pd.Disconnect();
    
    pd.Connect();
    Person pdel=pd.Read().get(0);
    pdel.setAge(11);
    pd.Update(pdel);
    assertEquals(pdel.Age, pd.Read().get(0).Age);
    pd.Disconnect();
	}
	
	@Test
	public void test_Read() throws ClassNotFoundException, SQLException {
    Person p = new Person();
    p.setAge(10);
    p.setLname("GG");
    p.setFname("Max");
    Person p2 = new Person();
    p2.setAge(100);
    p2.setLname("GG2");
    p2.setFname("Max2");
    pd.Create(p);
    pd.Create(p2);
    Person p3= pd.Read().get(0);
    assertEquals(p.getAge(), p3.getAge());
   // pd.Disconnect();
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
