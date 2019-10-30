//BankServiceImpl.java(Impl class)
package com.nt.comp;

public class BankServiceImpl implements BankService {

	@Override
	public String deposite(int accNo, float amt) {
		return "depositing    "+amt+ "into account number:::"+accNo;
	}

}
