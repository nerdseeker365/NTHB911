package com.nt.dao;

public interface OneToManyBiDAO {
	public  void loadDataUsingParentSideJoins();
	public  void loadDataUsingChild();
	public  void loadDataUsingParent();
	public  void  loadDataUsingQBC();
	public void  loadDataUsingJPAQBC();
	
}
