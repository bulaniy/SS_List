
public class Arr implements Cloneable, xList {
	
static //---------------------------initialisation section-------------------------//
int[] mas; //= new int[100];
static int ind;

Arr(){     //default constructor
    mas = new int[110];
    ind=0;
}

Arr(int size){     //constructor with params
    mas = new int[size];
    ind=0;
}

Arr(int[] a){  //constructor on array
	mas = new int[10];
	ind=0;
	for (int i=0; i<a.length; i++)
	{
	mas[i]=a[i];
	ind++;
	}
}

	Arr(Arr a){
		mas = new int[110];
		ind=0;
		for (int i=0; i<mas.length; i++)
		{
			mas[i]=a.mas[i];
		    ind++;
		}
	}
	


public Arr clone() {
Arr obj = null;
try {
	obj = (Arr) super.clone();
} catch (CloneNotSupportedException e) {
	e.printStackTrace();
}
return obj;
}

//---------------------------Main Class----------------------------//

@Override
public String toString(){
	String str = "";
	//Object String;
	for (int i=0; i<ind; i++)
	 str += i + ":= "+mas[i]+"; ";
	return str;
}


public int[] toArray(){
	int[] b =new int[ind];
	for (int i=0; i<ind; i++)
	b[i]=mas[i];
	return b;
	
}

public void addEnd(int val){
	resize();
	mas[ind++]=val;
    }

public void delEnd(){
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty"); 
	ind--;
    }
public void addStart(int val){
    resize();
	for(int i=ind; i>0;--i){
		mas[i]=mas[i-1];}
	mas[0]=val;
	ind++;
    }
public void delStart(){
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty"); 
	for(int i=0;i<ind;i++)
    mas[i]=mas[i+1];
	ind--;
	}

public int size(){   
	return ind;
	}

public int get(int pos){
	if  (ind<pos) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
	return mas[pos];
	}

public void set(int pos, int val) 
{
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty");
    else if (pos>ind) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
    mas[pos]=val;
	}
     
public void addValtoIndex(int pos, int val){
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty");
    else if (pos>ind) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
	for (int i = pos; i<ind; i++)
	mas[i+1]=mas[i];
	ind++;
	mas[pos]=val;
	}


public void delValfromIndex(int pos){
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty"); 
	for (int i = pos; i<ind; i++)
	mas[i]=mas[i+1];
	ind--;
	}

public void resize(){
	if (ind==mas.length-5){
	int i;
	int[] mas_new = new int[(int) (mas.length*(float) 1.3)];
	for (i=0; i<ind;i++)
		mas_new[i]=mas[i];
	    mas=mas_new;
	}
}

public void sort()
    {
    for (int a=0; a<ind; a++)
    for (int i=0; i<a; i++)
	if (mas[i]>mas[i+1]){
	int c = mas[i+1];
        mas[i+1]=mas[i];
        mas[i]=c;
        }}

public void sort_choose(){
	int a,i, temp, min = 0; 
	for ( a=0; a<ind; a++) {
		min=a;
    for ( i=a+1; i<ind; i++)
         if (mas[i]<mas[min])
        	 min=i;
    temp=mas[a];
    mas[a]=mas[min];
    mas[min]=temp;
	}
        }

public void sort_insert(){
	int a,i, temp;
	for (a=1; a<ind; a++)
	{
	   temp=mas[a];
	   i=a;
	   while (i>0 && mas[i-1]>=temp)
		{
			mas[i]=mas[i-1];
			--i;
		}
	mas[i]=temp;
	}
}

}
