package Person;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class PersonGUI {

	public static void main(String[] args) {
    UIFrame f = new UIFrame();
    f.setSize(300, 300);
    f.setVisible(true);
	}
}

 class UIFrame extends JFrame {
	 public UIFrame() {
		    JPanel pan = new JPanel(new BorderLayout()); 
		    add(pan);
		    TableModel m = new MTableModel();
		   // JTable table = new JTable(cells, columnNames);
		    //However, it should not be too difficult for you to extend DefaultTableModel 
		    //and override a method like getValueAt(int, int) to return the correct value from the findAll() list.
		    JTable table = new JTable(m);
		    table.setAutoCreateRowSorter(true);
		    pan.add(new JScrollPane(table),BorderLayout.CENTER);
		    JPanel pan_button = new JPanel();
		    JButton b = new JButton("Read", new ImageIcon("d:\\person.gif"));
		    JButton l = new JButton("Load", new ImageIcon("d:\\person.gif"));
		    pan.add(pan_button,BorderLayout.SOUTH);
		    pan_button.add(b,BorderLayout.NORTH);
		    pan_button.add(l, BorderLayout.NORTH);
	}	

 //private Object[][] cells = {{"Mercury", 224, 0, Color.yellow},
	//	 {"Mars", 453,1, Color.blue}};
 
 
 //private String[] columnNames = {"Planet", "Radius", "Moons", "Color"};
 
 }
 class MTableModel extends DefaultTableModel
 {
		private Connection connection;
		private PreparedStatement insert, select;
		private ArrayList arr;
	
	@Override
	public int getColumnCount() {
		
		return 4;
	}

	@Override
	public int getRowCount() {
		
		return 3;
	}

	@Override
	public Object getValueAt(int r, int c) {
	Person_Dao d = new Person_Dao();
	try {
		d.Connect();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		try {
			 arr = (ArrayList) d.Read();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Object obj = null;
		Person p = (Person) arr.get(r);
			
				//rs.absolute(r+1);     //row
			
			Field[] f = p.getClass().getFields();
		  
			obj = f[c].getGenericType();
	
		    
			//obj =  rs.getObject(c+1); //columns
			return obj;
	}
	 
 }