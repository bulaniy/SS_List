import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DS_DB implements IDS
{

	/**
	 * @param args
	 */

	private Connection connection;
	private PreparedStatement insert, select;
	
	@Override
	public void Save(BList b) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
	{
		Class.forName("org.h2.Driver");
		connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		insert= connection.prepareStatement(" delete from d1; delete from d2;delete from base");
	    insert.execute();
		if (b.size()>0) 
		{  
	    for (int i=0; i<b.size();i++)
	    {
	    	Base bs = b.get(i);
	    	insert= connection.prepareStatement(bs.toDB());
		    insert.execute(); 	
	    }
	}
    }	
	
	
	@Override
	public BList Load() throws FileNotFoundException, ClassNotFoundException, SQLException
	{
		BList b = new BList();
		String[] str = new String[100];
		Class.forName("org.h2.Driver");
		connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		select= connection.prepareStatement("select * from base b left join d1 d1 on d1.id_base=b.id" +
				" left join d2 d2 on d2.id_base = b.id" +
				" where d1.id is null and  d2.id is null");
		ResultSet rs = select.executeQuery();
		 while (rs.next()) {
		      str[2]=rs.getString(1);
		      str[4]=rs.getString(2);
		      Factory_BList bl =new Factory_BList();
		      b.add(bl.getBase("Base", str));
		    }
		  select.clearBatch();
		 
		   select= connection.prepareStatement("select * from base b join d1 d1 on d1.id_base=b.id");
			ResultSet rs2 = select.executeQuery();
			 while (rs2.next()) {
			      str[2]=rs.getString(1);
			      str[4]=rs.getString(2);
			      str[6]=rs.getString(6);
			      str[8]=rs.getString(7);
			      Factory_BList bl =new Factory_BList();
			      b.add(bl.getBase("D1", str));
			      System.out.println("good");
			    }
			 
			 select= connection.prepareStatement("select * from base b join d2 d2 on d2.id_base=b.id");
				ResultSet rs3 = select.executeQuery();
				 while (rs3.next()) {
				      str[2]=rs.getString(1);
				      str[4]=rs.getString(2);
				      str[6]=rs.getString(6);
				      Factory_BList bl =new Factory_BList();
				      b.add(bl.getBase("D2", str));
				    }
		return b;
	}
}

