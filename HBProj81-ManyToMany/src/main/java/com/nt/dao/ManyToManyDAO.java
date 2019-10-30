package com.nt.dao;

public interface ManyToManyDAO {
	public  void saveDataUsingParent();
	public  void saveDataUsingChild();
	public  void loadDataUsingParent();
	public  void deleteAParentFromAChild();
	

}
