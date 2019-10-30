package com.nt.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomCuponIdGenerator implements IdentifierGenerator {
	
	public CustomCuponIdGenerator() {
		System.out.println("CustomCuponIdGenerator.CustomCuponIdGenerator()");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
		System.out.println("CustomCuponIdGenerator.generate(-,-)");
		Random rad=null;
		int val=0;
		//generate Random number
		rad=new Random();
		val=rad.nextInt(10000);
		return val;
	}

}
