import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DS_CSV implements IDS
{

	/**
	 * @param args
	 */

	@Override
	public void Save(BList b) throws FileNotFoundException, IOException
	{
	FileWriter out = new FileWriter("c:\\test.csv");
	for (int i=0; i<b.size(); i++)
	out.write(b.get(i).toString()+"\r\n");
	out.close();		
    }	
	
	@Override
	public BList Load() throws FileNotFoundException
	{
		    Scanner in = new Scanner(new FileReader("c:\\test.csv"));
			BList b = new BList();	
			while (in.hasNext())
			{
				String line = in.nextLine();
				String[] tokens = line.split("\\|");
			    Factory_BList bl =new Factory_BList();
			    b.add(bl.getBase(tokens[0], tokens));  
			}
			return b;	
		}
	}


