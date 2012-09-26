import java.io.Serializable;
public class D2 extends Base  implements Serializable
{
	String x;
	
	public D2()
	{
		a=3;
		b=4;
		x="HELLLO";
	}
	
	@Override
	public String toString()
	{
		return "D2|a=|"+a+"|b=|"+b+"|x=|"+x;
	}

	public String toXML()
	{
		return  
				"<class>\n<name>D2</name>" +"\n"+
				"<a>"+a+"</a>" +"\n"+
				"<b>"+b+"</b>" + "\n"+
				"<x>"+x+"</x>\n</class>";	    
	}

	public String toJson()
	{
	return "{\n\"inner\":"+super.toJson()+",\n\"name\":\"D2\",\n\"x\":\""+x+"\"\n}";
	}
	
	public String toDB(){
		return  
		super.toDB()+";"+"insert into D2 (id_base, id, x) values (seq_base.currval, next value for seq_base, '"+x+"')";
		
		}

}
