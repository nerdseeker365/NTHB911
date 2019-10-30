package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import lombok.Data;

@Data
@Entity
/*@NamedNativeQueries(value= {@NamedNativeQuery(name="GET_ALL_POLICIES_BY_TENURE_RANGE",query="SELECT  POLICYID,POLICYNAME,POLICYHOLDERNAME,TENURE FROM INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?",resultClass=InsurancePolicy.class),
		                                                     @NamedNativeQuery(name="GET_POLICY_DETAILS_BY_NAMES",query="SELECT  POLICYNAME,TENURE FROM INSURANCEPOLICY   WHERE POLICYHOLDERNAME   IN(:name1,:name2,:name3)")
                                                            }
                                              )
*/

@NamedNativeQueries(value= {@NamedNativeQuery(name="GET_ALL_POLICIES_BY_TENURE_RANGE",query="SELECT  POLICYID,POLICYNAME,POLICYHOLDERNAME,TENURE FROM INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?",resultClass=InsurancePolicy.class),
        @NamedNativeQuery(name="GET_POLICY_DETAILS_BY_NAMES",query="SELECT  POLICYNAME,TENURE FROM INSURANCEPOLICY   WHERE POLICYHOLDERNAME   IN(:name1,:name2,:name3)")
       }
)

public class InsurancePolicy {
	@Id
	private  int policyId;
	private  String policyName;
	private  String policyHolderName;
	private  int tenure;
	

}
