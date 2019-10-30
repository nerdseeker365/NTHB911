package com.nt.dao;

import java.util.List;

import com.nt.entity.InsurancePolicy;

public interface InsurancePolicyDAO {
	public List<InsurancePolicy>  getPageData(int startPos,int pageSize);
	public  int  getRecordsCount();

}
