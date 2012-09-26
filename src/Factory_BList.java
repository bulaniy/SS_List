
class Factory_BList {
	
	public Base getBase(String name, String[] tokens)
	{   
		
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


}
