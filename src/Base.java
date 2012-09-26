import java.io.Serializable;
public class Base implements Serializable {

	int a;
	int b;
	
	public Base()
	{
		a=1;
		b=1;
	}
	@Override
	public String toString()
	{
		return "Base|a=|"+a+"|b=|"+b;
	}
	
	public String toXML()
	{
		return
				"<class>\n<name>Base</name>" +"\n"+
				"<a>"+a+"</a>" +"\n"+
				"<b>"+b+"</b>\n</class>";
	}
	
	public String toJson()
	{
		return "{\n\"name\":\"Base\",\n\"a\":\""+a+"\",\n\"b\":\""+b+"\"\n}";
	}
	
	public String toDB(){
		return "insert into Base (id, a, b) values (next value for seq_base, "+a+", "+b+")";   	
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	
	}

