package com.nt.basics;

import java.util.Date;

public class UnderstandingClass {

	public static void main(String[] args) throws Exception{
		Class c1=null,c2=null,c3=null,c4=null;
		String s1=null;
		Date d1=null;
		
		//Different ways creating obj for java.lang.Class
		 s1=new String("hello");
		 c1=s1.getClass();
		 System.out.println("c1 class  name::"+c1.getClass()+" c1 data "+c1.toString());
        System.out.println("................................");
        c2=Class.forName("java.util.Date");
        System.out.println("c2 class  name::"+c2.getClass()+" c2 data "+c2.toString());
		d1=(java.util.Date)c2.newInstance();
		System.out.println("d1 class  name::"+d1.getClass()+" d1 data "+d1.toString());
		System.out.println(".......................");
		c3=Integer.class;
		System.out.println("c3 class  name::"+c3.getClass()+" c3 data "+c3.toString());
		c4=Test.class;
		System.out.println("c4 class  name::"+c4.getClass()+" c4 data "+c4.toString());
		System.out.println(".......................");



	}

}
