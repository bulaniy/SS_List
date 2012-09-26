import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DS_XML implements IDS 
{

		@Override
		public void Save(BList b) throws FileNotFoundException, IOException 
		{
			FileWriter out = new FileWriter("c:\\text.xml");
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
			out.write("<data>\n");
			for (int i=0; i<b.size(); i++)
			out.write(b.get(i).toXML()+"\n");
			out.write("</data>");
			out.close();	
	    }	
		

		@Override
		public BList Load() throws FileNotFoundException 
		{
			Scanner in = new Scanner(new FileReader("c:\\text.xml"));
			BList b = new BList();
			String[] resultString = new String[100];
			int i=0;
			while (in.hasNext())
			{
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
					 Factory_BList bl = new Factory_BList();
				     b.add(bl.getBase(resultString[0], resultString));   
					i=0;
					}	
			}
			return b;
	    }
 }
