package com.nt.factory;

import com.nt.comp.BankService;
import com.nt.comp.BankServiceImpl;
import com.nt.proxy.BankServiceImplProxy;

public class BankServiceFactory {
	
	public  static  BankService  getBankService(boolean demonitization) {
		 if(!demonitization)
		     return  new BankServiceImpl(); //read obj
		 else
			 return  new BankServiceImplProxy(); //proxy object
	}

}
