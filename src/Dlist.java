public class Dlist implements Cloneable, xList {
	int[] mas; //= new int[100];
	int begin; //mas.length/2;
	int end;  //begin;
//---------------------------------------Constructor---------------------------//	
	Dlist(){     //default constructor
	    mas = new int[100];
	    begin=mas.length/2;;
	    end=begin;
	}

	Dlist(int size){     //constructor with params
	    mas = new int[size];
	    begin=mas.length/2;;
	    end=begin;
	}

	Dlist(int[] a){  //constructor on array
		mas = new int[10];
		  begin=mas.length/2;;
		    end=begin;
		for (int i=begin; i<a.length; i++)
		{
		mas[i]=a[i];
	
		}
	}

	Dlist(Dlist a){
			mas = new int[110];
			  begin=mas.length/2;;
			    end=begin;
			for (int i=begin; i<mas.length; i++)
			{
				mas[i]=a.mas[i];
			  
			}
		}
	
	public Dlist clone() {
		Dlist obj = null;
	try {
		obj = (Dlist) super.clone();
	} catch (CloneNotSupportedException e) {
		e.printStackTrace();
	}
	return obj;
	}
	
//--------------------------------------Main class---------------------------------------------//	
	@Override
	public int[] toArray() {
	
		int[] b =new int[end-begin];
		for (int i=0; i<end-begin; i++)
		b[i]=mas[begin+i];
		return b;
	}
	
	@Override
	public String toString(){
		String str = "";
		for (int i=0; i<(end-begin); i++)
			 str += i + ":= "+mas[begin+i]+"; ";
		return str;
	}
	

	@Override
	public void addEnd(int val) {
	    mas[end]=val;
	    end++;
	}

	@Override
	public void delEnd() {	
		end--;
	}

	@Override
	public void addStart(int val) {
		mas[begin-1]=val;
		begin--;
	}

	@Override
	public void delStart() {
		begin++;
	}

	@Override
	public int size() {
		return end-begin;
	}

	@Override
	public int get(int pos) {
		if  (end-begin<pos) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
		return mas[begin+pos];
	}

	@Override
	public void set(int pos, int val) {
		if (end-begin==0) throw new IndexOutOfBoundsException("our mas is empty");
	    else if (pos>end-begin) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
	mas[begin+pos]=val;
	}

	@Override
	public void addValtoIndex(int pos, int val) {
	int i=0;	
	for (i=begin+pos-1;i<end;i++)
	mas[pos+1]=mas[pos];
	mas[pos]=val;
	end++;

	}

	@Override
	public void delValfromIndex(int pos) {
		int i;
	for (i=begin+pos+1;i<end;i++)
	mas[pos]=mas[pos+1];
	end--;	
	}

	@Override
	public void resize() {
	if (end==mas.length-5 || (begin-5)==0){
	int i;
	int[] mas_new = new int[(int) (mas.length*(float) 1.3)];
	for (i=0; i<end-begin;i++)
		mas_new[i]=mas[i];
	    mas=mas_new;
	}}
	

	@Override
	public void sort() {
		for (int a=0; a<end-begin; a++)
		    for (int i=0; i<a; i++)
			if (mas[i]>mas[i+1]){
			int c = mas[i+1];
		        mas[i+1]=mas[i];
		        mas[i]=c;
		        }	
	}

	@Override
	public void sort_choose() {
		int a,i, temp, min = 0; 
		for (a=begin; a<end-begin; a++) {
			min=a;
	    for ( i=a+1; i<end-begin; i++)
	         if (mas[begin]<mas[min])
	        	 min=i;
	    temp=mas[a];
	    mas[a]=mas[min];
	    mas[min]=temp;
		}
	}

	@Override
	public void sort_insert() {
		int a,i, temp;
		for (a=begin+1; a<end-begin; a++)
		{
		   temp=mas[a];
		   i=a;
		   while (i>begin && mas[begin-1]>=temp)
			{
				mas[i]=mas[i-1];
				--i;
			}
		mas[i]=temp;
		}
	}

}
