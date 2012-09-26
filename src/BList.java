import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BList implements Cloneable, Serializable, List {

	private static final long serialVersionUID = 1L;
static //---------------------------initialisation section-------------------------//
Base[] mas;
static int ind;

BList()
{     //default constructor
    mas = new Base[110];
    ind=0;
}

BList(int size)
{     //constructor with params
    mas = new Base[size];
    ind=0;
}

BList(Base[] a)
{  //constructor on array
	mas = new Base[10];
	ind=0;
	for (int i=0; i<a.length; i++)
	{
	mas[i]=a[i];
	ind++;
	}
}

public BList clone() 
{  //clone
BList obj = null;
try {
	obj = (BList) super.clone();
    } 
catch (CloneNotSupportedException e){ 
	e.printStackTrace();}
return obj;
}

@Override
public String toString()
{
	String str = "";
	for (int i=0; i<ind; i++)
	str += i + ":= "+mas[i]+"; ";
	return str;
}

public void addEnd(Base val)
{
	resize();
	mas[ind++]=val;
}

public void delEnd()
{
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty"); 
	ind--;
}

public void addStart(Base val)
{
    resize();
	for(int i=ind; i>0;--i){
	mas[i]=mas[i-1];}
	mas[0]=val;
	ind++;
}

public void delStart()
{
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty"); 
	for(int i=0;i<ind;i++)
    mas[i]=mas[i+1];
	ind--;
}

public int size()
{   
	return ind;
}

public Base get(int pos)
{
	if  (ind<pos) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
	return mas[pos];
}

public void set(int pos, Base val) 
{
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty");
    else if (pos>ind) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
    mas[pos]=val;
}
     
public void addValtoIndex(int pos, Base val)
{
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty");
    else if (pos>ind) throw new IndexOutOfBoundsException("element "+pos+"does not exists"); 
	for (int i = pos; i<ind; i++)
	mas[i+1]=mas[i];
	ind++;
	mas[pos]=val;
}


public void delValfromIndex(int pos)
{
	if (ind==0) throw new IndexOutOfBoundsException("our mas is empty"); 
	for (int i = pos; i<ind; i++)
	mas[i]=mas[i+1];
	ind--;
}

public void resize()
{
	if (ind==mas.length-5)
	{
	int i;
	Base[] mas_new = new Base[(int) (mas.length*(float) 1.3)];
	for (i=0; i<ind;i++)
		mas_new[i]=mas[i];
	    mas=mas_new;
	}
}
/*----------------------Impl List -----------------------*/
@Override
public boolean isEmpty() {
	return (ind>0);
}

@Override
public boolean contains(Object o) { 
	return false;
}

@Override
public Iterator iterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Object[] toArray(Object[] a) {
return null;
}

@Override
public boolean add(Object e) {
    resize();
	for(int i=ind; i>0;--i)
	mas[i]=mas[i-1];
	mas[0]=(Base) e;
	ind++;
	return false;
}

@Override
public boolean remove(Object o) {
for (int i=0; i<ind; i++)
	if (mas[i].equals(o))
	{
		for (int a = i; a<ind; a++)
			mas[a]=mas[a+1];
			ind--;
			return true;
	}
	return false;
}

@Override
public boolean containsAll(Collection c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(Collection c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(int index, Collection c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean removeAll(Collection c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean retainAll(Collection c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	mas=null;
}

@Override
public Object set(int index, Object element) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void add(int index, Object element) {
	// TODO Auto-generated method stub
	
}

@Override
public Object remove(int index) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int indexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int lastIndexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public ListIterator listIterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ListIterator listIterator(int index) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Object[] toArray() {
	Base[] b =new Base[ind];
	for (int i=0; i<ind; i++)
	b[i]=mas[i];
	return b;
}


}
