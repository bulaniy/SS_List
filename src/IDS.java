import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public interface IDS {
public void Save(BList b) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
public BList Load() throws FileNotFoundException, ClassNotFoundException, SQLException;

/*
 
public void Save_Fabric(String t) throws IOException{
	if (t=="csv")
	{
	FileWriter out = new FileWriter("c:\\test."+t);
	for (int i=0; i<ind; i++)
	out.write(mas[i].toString()+"\r\n");
	out.close();
	}
	else if (t=="xml")
	{
		FileWriter out = new FileWriter("c:\\test."+t);
		out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
		out.write("<data>\n");
		for (int i=0; i<ind; i++)
		out.write(mas[i].toXML()+"\n");
		out.write("</data>");
		out.close();	
	}
	else if (t=="json"){
		FileWriter out = new FileWriter("c:\\test."+t);
		for (int i=0; i<ind; i++)
		out.write(mas[i].toJson()+"\n");
		out.close();
	}
}


public void SaveCSV() throws FileNotFoundException, IOException{
	FileWriter out = new FileWriter("c:\\test.csv");
	for (int i=0; i<ind; i++)
	out.write(mas[i].toString()+"\r\n");
	out.close();	
	
}


public Base[] LoadJson() throws FileNotFoundException   //доделать с замещением полей Base
{
	Scanner in = new Scanner(new FileReader("c:\\test.json"));
	Base[] b = new Base[ind];
	String[] resultString = new String[100];
	int a = 0,i=0;
	while (in.hasNext()){
		String tempstr, subjectString = in.nextLine();
		Pattern regex = Pattern.compile(":.*,");
		Matcher regexMatcher = regex.matcher(subjectString);	
		if (regexMatcher.find()) {
			tempstr = regexMatcher.group();
		    resultString[i++] = tempstr.substring(2,tempstr.length()-2);
		    resultString[i++]="";
		}
		if (subjectString.equals("}"))
			{
			b[a++] = factory(resultString[0], resultString);	
			i=0;
			}	
	}
	return b;	
}
public Base[] LoadCSV() throws FileNotFoundException
{
	Scanner in = new Scanner(new FileReader("c:\\test.csv"));
	Base[] b = new Base[ind];
	for (int i=0; i<ind; i++){
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
	    b[i] = factory(tokens[0], tokens);	
	}
	return b;	
}



public void SaveXMLDOM() throws TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException, IOException, SAXException{

	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	InputStream in = new FileInputStream("c:\\text.xml");
	Document doc = dbFactory.newDocumentBuilder().parse(in);
	in.close();
	Element rootElement =  doc.createElement("data");
	NodeList nl = doc.getChildNodes();
	for (int i=0; i<nl.getLength();i++)
	{
		Element e =   doc.createElement(nl.item(i).getNodeName());
		Text textNode =(Text) doc.createTextNode(nl.item(i).getNodeValue());
		rootElement.appendChild(e);
		e.appendChild(textNode);
	}
	Transformer t = TransformerFactory.newInstance().newTransformer();
	t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("c:\\text3.xml")));
}


private void writeObject() throws IOException
	{
		FileOutputStream fo =	new FileOutputStream("c:\\text4.xml");
		Object objSave = mas; 
		ObjectOutputStream oos = new ObjectOutputStream(fo);
	}

public void AutoSerializable() throws IOException
		{
				FileOutputStream fo =	new FileOutputStream("c:\\text4.xml");
				Object objSave = mas; 
				ObjectOutputStream oos = new ObjectOutputStream(fo);
				oos.writeObject(objSave);
		}


/*
    public void SaveXML() throws TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException, IOException
    {
	FileWriter out = new FileWriter("c:\\text.xml");
	out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
	out.write("<data>\n");
	for (int i=0; i<ind; i++)
	out.write(mas[i].toXML()+"\n");
	out.write("</data>");
	out.close();	
	};
	

	public Base[] LoadXML() throws ParserConfigurationException, SAXException, IOException{		
		   {
			Scanner in = new Scanner(new FileReader("c:\\text.xml"));
			Base[] b = new Base[ind];
			String[] resultString = new String[100];
			int a = 0,i=0;
			while (in.hasNext()){
				String tempstr, subjectString = in.nextLine();
				Pattern regex = Pattern.compile("\\>.*</");
				Matcher regexMatcher = regex.matcher(subjectString);	
				if (regexMatcher.find()) {
					tempstr = regexMatcher.group();
				    resultString[i++] = tempstr.substring(1,tempstr.length()-2);
				    resultString[i++]="";
				}
				if (subjectString.equals("</class>"))
					{
					b[a++] = factory(resultString[0], resultString);	
					i=0;
					}	
			}
			return b;	
		}
		
		/*	Base[] b = new Base[ind];
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		File f = new File("c:\\text.xml");
		Document doc = dBuilder.parse(f);

		/////////////Start parsing///////////////////////
		Element root = doc.getDocumentElement();
		String str = root.getTagName();
		NodeList rootchild= root.getChildNodes();
		String[] t = new String[100];
		int a = 0,z=0;

		for (int i=0; i<rootchild.getLength();i++){
			Node child = rootchild.item(i);
		
			if (child instanceof Element)
				{
				Element subElement = (Element) child;
				Text textNode = (Text) subElement.getFirstChild();
				String text = textNode.getData();
				t[z]=text;
				z+=2;
				if (a<i){	
					b[i]= factory(t[0], t);
					a++;}
			}
	
		}
		return b;
		
	}
	



public Base factory(String name, String[] tokens){
	if (name.equals("Base"))
	{
		Base b = new Base();
		b.a=Integer.parseInt(tokens[2]);
		b.b=Integer.parseInt(tokens[4]);
		return b;
	}
	else if (name.equals("D1"))
	{
		D1 b = new D1();
		b.a=Integer.parseInt(tokens[2]);
		b.b=Integer.parseInt(tokens[4]);
		b.c=Integer.parseInt(tokens[6]);
		b.z= Float.parseFloat(tokens[8]);
		return b;
	}
	else
	{
		D2 b = new D2();
		b.a=Integer.parseInt(tokens[2]);
		b.b=Integer.parseInt(tokens[4]);
		b.x=tokens[6];
		return b;
	}
}
 */
}
