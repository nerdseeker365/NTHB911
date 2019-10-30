package com.nt.test;

import com.nt.comp.BankService;
import com.nt.factory.BankServiceFactory;

public class ProxyPatternTest {

	public static void main(String[] args) {
		BankService service=null;
		//get Service class obj
		service=BankServiceFactory.getBankService(false);
		//invoke method
		System.out.println(service.deposite(1001, 9000));
		System.out.println("service obj class"+service.getClass());
		System.out.println("......................................");
		System.out.println(service.deposite(1002, 800000));
		System.out.println("service obj class"+service.getClass());
		

	}

}
