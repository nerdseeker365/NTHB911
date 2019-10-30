package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.InsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOFactory;
import com.nt.dto.InsurancePolicyDTO;
import com.nt.entity.InsurancePolicy;

public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	public List<InsurancePolicyDTO> fetchPageData(int pageNo,int pageSize) {
		InsurancePolicyDAO dao=null;
		List<InsurancePolicy> list=null;
		List<InsurancePolicyDTO> listDTO=new ArrayList();
		int startPos=0;
		//get DAO
		dao=InsurancePolicyDAOFactory.getInstance();
		//get StatrPosition
		startPos=getStartPosition(pageNo, pageSize);
		//use DAO
		list=dao.getPageData(startPos, pageSize);
		//Convert list Domain class objs to list DTO class objects
		list.forEach(policy->{
			InsurancePolicyDTO dto=new InsurancePolicyDTO();
			dto.setPolicyId(policy.getPolicyId());
			dto.setPolicyName(policy.getPolicyName());
			dto.setPolicyHolderName(policy.getPolicyHolderName());
			dto.setTenure(policy.getTenure());
			listDTO.add(dto);
		});
		System.out.println(listDTO.size());
		return listDTO;
	}
	
	//helper
	private int getStartPosition(int pageNo, int pageSize) {
		int startPos=0;
		startPos=(pageNo*pageSize)-pageSize;
		return startPos;
	}

	public int getPageCount(int pageSize) {
		InsurancePolicyDAO  dao=null;
		int recordsCount=0;
		int pagesCount=0;
		//get DAO 
		dao=InsurancePolicyDAOFactory.getInstance();
		//get records count
		recordsCount=dao.getRecordsCount();
		pagesCount=recordsCount/pageSize;
		if(recordsCount%pageSize!=0)
			pagesCount++;
		
		return pagesCount;
	}

}
