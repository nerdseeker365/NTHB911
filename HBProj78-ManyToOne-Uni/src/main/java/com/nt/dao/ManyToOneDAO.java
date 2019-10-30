package com.nt.dao;

public interface ManyToOneDAO {
	 public  void saveData();
	 public void loadData();
	 public  void addNewChildToExistingParent();
	 public  void  addExistingChildToNewParent();
	 public  void  deleteOneChildOfAParent();

}
