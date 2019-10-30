package com.nt.dao;

public interface OneToManyDAO {
	public void  saveData();
	public void loadData();
	public void loadDataUsingQBC();
	public void deletingOneChildFromCollectionOfChilds();
}
