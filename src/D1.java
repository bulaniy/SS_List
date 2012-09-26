import java.io.Serializable;
public class D1 extends Base  implements Serializable
{
	int c;
	float z;

	public D1()
	{
		a=2;
		b=2;
		c=3;
		z=(float) 4.0;
	}

	@Override
	public String toString()
	{
		return "D1|a=|"+a+"|b=|"+b+"|c=|"+c+"|z=|"+z;
	}

	public String toXML()
		{
			return  "<class>\n<name>D1</name>"+"\n"+
					"<a>"+a+"</a>" +"\n"+
					"<b>"+b+"</b>" +"\n"+
					"<c>"+c+"</c>"+"\n"+
					"<z>"+z+"</z>\n</class>";			
		}

	public String toJson()
		{
		return "{\n\"inner\":"+super.toJson()+",\n\"name\":\"D1\",\n\"c\":\""+c+"\",\n\"z\":\""+z+"\"\n}";
		}
	
	public String toDB(){
		return  super.toDB()+";"+"insert into D1 (id_base, id, c, z) values (seq_base.currval, next value for seq_base, "+c+", "+z+")";		
		}
}
