package com.nt.dao;

import java.util.List;

import com.nt.entity.License;

public interface OneToOneFKDAO {
   public int saveDataUsingChild();
   public List<License> loadDataUsingChild();
}
