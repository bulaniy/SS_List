import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

	 @RunWith(value = Parameterized.class)
	 public class testIDS 
	 {
	         public IDS ds;
	         public BList bl;
	
	  public testIDS(IDS ds, BList bl)
	  {
	         this.ds = ds;
	         this.bl = bl;      
	  }
	     
	 
	  @Parameters
	  public static Collection<Object[]> data() 
	  {
	        Object[][] data = new Object[][] 
	        		{
	        		{new DS_CSV(), null}, {new DS_XML(), null}
	        		};
	        return Arrays.asList(data);
	   }
	      
	   @Test
	   public void ParametersTest0() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException 
	   {
	        BList orig = new BList();
			ds.Save(orig);
			BList exp = ds.Load();
			assertEquals(orig.size(), exp.size());	
	   } 
	
		@Test
		public void ParametersTest1() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException 
		{
			BList orig = new BList();
			orig.add(new Base());
			ds.Save(orig);
			BList exp = ds.Load();
			assertEquals(orig.toString(), exp.toString());	
		} 
		
	
		@Test
		public void ParametersTestN() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException 
		{
			BList orig = new BList();
			orig.add(new Base());
			orig.add(new D1());
			ds.Save(orig);
			BList exp = ds.Load();
			assertEquals(orig.toString(), exp.toString());	
		} 
}

