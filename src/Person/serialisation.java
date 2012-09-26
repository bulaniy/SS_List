package Person;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;


public class serialisation {
public static void main (String[] args) throws FileNotFoundException, IOException, TransformerFactoryConfigurationError, TransformerException, 
ParserConfigurationException, SAXException, ClassNotFoundException, SQLException
{
	Person per = new Person();
	per.setAge(20);
	per.setFname("GG");
	per.setLname("HH");
	per.setId(1);
	per.setNomer("921009200");
	Person per2 = new Person();
	per2.setAge(33);
	per2.setFname("FF");
	per2.setLname("GTG");
	per2.setId(2);
	per2.setNomer("921595689");
	Person per3 = new Person();
	per3.setAge(333);
	per3.setFname("rFF");
	per3.setLname("rGTG");
	per3.setId(2);
	ArrayList<Person> arrp= new ArrayList<Person>();
	arrp.add(per);
	arrp.add(per2);
    Person_XML p = new Person_XML();
    p.Create(arrp);
    ArrayList<Person> arrout= new ArrayList<Person>();
    arrout=(ArrayList<Person>) p.Read();
   // Person pp = p.Read().get(0);
   // p.Update(pp);
   // Person pep = p.Read().get(0);
   // System.out.println(pp.toString());
    for ( int i=0; i<arrout.size(); i++)
    	System.out.println(arrout.get(i).toString());
    
    p.Update(per3);
    
    ArrayList<Person> arrout2= new ArrayList<Person>();
    arrout2=(ArrayList<Person>) p.Read();
    for ( int i=0; i<arrout2.size(); i++)
    	System.out.println(arrout2.get(i).toString());
    
    p.Delete(per);
    ArrayList<Person> arrout3= new ArrayList<Person>();
    arrout3=(ArrayList<Person>) p.Read();
    for ( int i=0; i<arrout3.size(); i++)
    	System.out.println(arrout3.get(i).toString());
    System.out.println("Vse ok");
   
   
}
}
