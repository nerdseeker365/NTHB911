package com.nt.proxy;

import com.nt.comp.BankService;
import com.nt.comp.BankServiceImpl;

public class BankServiceImplProxy implements BankService {
	 BankService service=null;
	public BankServiceImplProxy() {
		service=new BankServiceImpl();
	}

	@Override
	public String deposite(int accNo, float amt) {
		if(amt>=100000)
			throw new IllegalArgumentException("we can not deposite more than 1 lac");
			else{
				//use real obj
				return service.deposite(accNo, amt);
			}
	}//method
}//class
