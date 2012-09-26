package Person;

public class Person 
{
	public String Fname,Lname;
	public Integer Age, Id;
	
	public Nomer n = new Nomer();
	
	public String getFname() 
	{
		return Fname;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public void setFname(String fname) 
	{
		Fname = fname;
	}
	public String getLname() 
	{
		return Lname;
	}
	public void setLname(String lname) 
	{
		Lname = lname;
	}
	public Integer getAge() 
	{
		return Age;
	}
	public void setAge(Integer age) 
	{
		Age = age;
	}
	public String getNomer() 
	{
		return n.getNomer();
	}
	public void setNomer(String nomer) 
	{
		n.setNomer(nomer);
	}
	
@Override
	public String toString(){
		return  ""+Id+", "+Fname+", "+Lname+", "+Age+", "+n.nomer+"";
		
	}

	

}
