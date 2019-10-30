package com.nt.service;

import java.util.List;

import com.nt.dto.InsurancePolicyDTO;

public interface InsurancePolicyService {
	public  List<InsurancePolicyDTO>  fetchPageData(int pageNo,int pageSize);
	public  int  getPageCount(int pageSize);

}
