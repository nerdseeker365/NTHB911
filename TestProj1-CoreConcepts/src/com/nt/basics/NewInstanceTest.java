package com.nt.basics;

import java.lang.reflect.Constructor;
import java.util.Date;

public class NewInstanceTest {

	public static void main(String[] args) throws Exception{
		Class c=null;
		Date d1=null,d2=null;
		Constructor cons=null;
		//Load class
		c=Class.forName(args[0]);
		//create obj of loaded using 0-param constructor
		d1=(Date) c.newInstance(); 
		//create obj of loaded using 3-param constructor
		  cons=c.getDeclaredConstructors()[5];
		  d2=(Date)cons.newInstance(95,10,4);
		  System.out.println("d1=="+d1+"  "+"d2=="+d2);
	}//main
}//class
