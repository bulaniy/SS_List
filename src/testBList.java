import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBList {

	BList arr  = null;
	Base b = new Base();
	D1 d1 = new D1();
	D2 d2 = new D2();
	
@Before
public void init(){
	arr  = new BList();
	
	b.a=10;
	b.b=11;	
	
	d1.a=12;
	d1.b=13;
	d1.c=14;
	d1.z=1;
	
	d2.a=15;
	d2.b=16;
	d2.x="Hello";

}

//----------------------------------------Constructor test-----------------------------------------//
@Test
public void testDefaultConstructor(){
	BList ar= new BList();
	assertEquals(110, ar.mas.length);
}

@Test
public void testConstructorWithParams(){
	BList ar= new BList(200);
	assertEquals(200, ar.mas.length);
	
}


@Test
public void testConstructorOnArray0(){
	Base[] array = {};
	BList ar= new BList(array);
	assertEquals(0, ar.size());
}
@Test
public void testConstructorOnArray1(){
	Base[] array = {b};
	BList ar= new BList(array);
	assertEquals(b, ar.get(0));
	assertEquals(1, ar.size());
}
@Test
public void testConstructorOnArrayN(){
	Base[] array = {b,d1,d2,b,d2,d1,b,b};
	BList ar= new BList(array);
	assertEquals(8, ar.size());
}


@Test
public void testConstructorOnClone0(){
	BList ar = new BList();
	BList arr = ar.clone();
	assertEquals(0,arr.size());
}


//----------------------------------------class test----------------------------------------------//

@Test
public void testtoString0()
{
assertEquals("", arr.toString());
}


@Test
public void testtoString1()
{
arr.add(b);
assertEquals("0:= Base|a=|10|b=|11; ", arr.toString());
}

@Test
public void testtoStringN()
{
arr.add(b);
arr.add(d1);
assertEquals("0:= D1|a=|12|b=|13|c=|14|z=|1.0; 1:= Base|a=|10|b=|11; ", arr.toString());
}

@Test
public void testtoArrays0()
{
Base[] t=new Base[arr.size()];
assertArrayEquals(t, arr.toArray());
}

@Test
public void testtoArrays1()
{
arr.add(b);
Base[] t={b};
assertEquals(t[0], arr.toArray()[0]);
assertArrayEquals(t, arr.toArray());
}

@Test
public void testtoArraysN()
{
arr.add(d1);
arr.add(b);
Base[] t={b,d1};
assertArrayEquals(t, arr.toArray());
}

@Test
public void testSizeN(){
	arr.addEnd(b);
	arr.addEnd(d2);
	assertEquals(2, arr.size());
}

@Test
public void testSize0(){
	assertEquals(0, arr.size());
}

@Test
public void testSize1(){
	arr.add(b);
	assertEquals(1, arr.size());
}


@Test
public void testSetN(){
	arr.addEnd(b);
	arr.set(0, d1);
	arr.addEnd(d2);
	arr.set(1, b);
	assertEquals(b, arr.get(1));
}


@Test (expected = IndexOutOfBoundsException.class)
public void testSet0(){
	arr.set(0, b);

}

@Test
public void testSet1(){
	arr.addEnd(d2);
	arr.set(0, d1);
	assertEquals(d1, arr.get(0));
	assertEquals(1, arr.size());
}

@Test
public void testGetN(){
	arr.addEnd(b);
	arr.addEnd(d1);
	assertEquals(d1, arr.get(1));
	assertEquals(2, arr.size());
}

@Test (expected = IndexOutOfBoundsException.class)
public void testGet1 (){
	arr.addEnd(b);
	arr.addEnd(d2);
	assertEquals(44, arr.get(10));
	assertEquals(2, arr.size());
}

@Test //(expected = IndexOutOfBoundsException.class)
public void testGet0(){
	assertEquals(null, arr.get(0));
}

@Test
public void testaddEnd0(){
	arr.addEnd(d2);
	assertEquals(d2, arr.get(arr.size()-1));
	assertEquals(d2, arr.get(0));
}

@Test
public void testaddStart0(){
	arr.addStart(d2);
	assertEquals(d2, arr.get(0));
}

@Test
public void testaddEnd1(){
	arr.addEnd(b);
	assertEquals(b, arr.get(arr.size()-1));
}

@Test
public void testaddEndN(){
	arr.addEnd(b);
	arr.addEnd(d1);
	assertEquals(b, arr.get(0));
	assertEquals(d1, arr.get(1));
}

@Test
public void testdelValfromIndex()
{
	arr.addEnd(b);
	arr.addEnd(d1);
	arr.delValfromIndex(1);
	assertEquals(b, arr.get(0));
	assertEquals(1, arr.size());	
}

@Test
public void testResize()
{
	int[] m= {0,1,2,3};
	Arr ar= new Arr(m);
	ar.addEnd(5);
	ar.resize();
	assertEquals(13, ar.mas.length);
	assertEquals(5, ar.size());
	
}


//------------------------------------------sort test----------------------------------------------//
/*
@Test 
public void testsort_choose0()
{  
   arr.sort_choose();
   assertEquals(0, arr.size());
}

@Test
public void testsort_choose1()
{
	arr.addStart(12);
    arr.sort_choose();
	assertEquals(12, arr.get(0));	
}

@Test
public void testsort_chooseN()
{
	arr.addEnd(3);
	arr.addStart(33);
    arr.sort_choose();
	assertEquals(3, arr.get(0));	
}

@Test
public void testsort0() 
{
    arr.sort();
    arr.sort();
    assertEquals(0, arr.size());
}

@Test 
public void testsort1() 
{
	arr.addEnd(12);
    arr.sort();
	assertEquals(12, arr.get(0));
}

@Test 
public void testsortN() 
{
	arr.addEnd(12);
	arr.addEnd(122);
    arr.sort();
	assertEquals(122, arr.get(1));
}


@Test
public void testsort_insert0()
{
	   arr.sort_insert();
       assertEquals(0, arr.size());
}

@Test
public void testsort_insert1()
{
	arr.addEnd(3);
	arr.sort_insert();
	assertEquals(3, arr.get(0));
	assertEquals(1, arr.size());
}

@Test
public void testsort_insertN()
{
	arr.addEnd(3);
	arr.addStart(33);
	arr.addStart(333);
	arr.addStart(12);
    arr.sort_insert();
	assertEquals(333, arr.get(3));	
}
*/


}
