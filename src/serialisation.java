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
	
	Base b = new Base();
	b.a=10;
	b.b=11;
	D1 d1 = new D1();
	d1.a=12;
	d1.b=13;
	d1.c=14;
	d1.z=1;
	D2 d2 = new D2();
	d2.a=15;
	d2.b=16;
	d2.x="Hello";
	
	BList arr = new BList();
	arr.addStart(b);
	arr.addEnd(d1);
	arr.addStart(d2);
	IDS ds = new DS_XML();

	/*arr.SaveCSV();
	
	Base[] bas = arr.LoadCSV();
	
	for (int i=0; i<bas.length; i++) 
	arr.addStart(bas[i]);
	System.out.println(arr.toString());*/
	
	
	//arr.SaveXML();
	
	/*Base[] bas2 = arr.LoadXML();
	for (int i=0; i<bas2.length; i++) 
	System.out.println(bas2[i].toString());	
	//arr.LoadXML();
	
	arr.SaveXMLDOM();
/*
	arr.Save_Fabric("json");
	Base[] bb = arr.LoadJson();
	for (int i=0; i<bb.length; i++) 
	System.out.println(bb[i].toString());	
	//bb.toString();
	
	arr.AutoSerializable();
	*/
	ds.Save(arr);
	BList bl = ds.Load();
	System.out.println(bl.toString());
	
	IDS ds2 = new DS_DB();
	ds2.Save(arr);
    Person_Dao p = new Person_Dao();
    p.Create();
    
	

}
}
