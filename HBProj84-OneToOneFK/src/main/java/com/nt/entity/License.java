package com.nt.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class License {
	private int lid;
	private String type;
	private Date validFrom;
	private Date validTo;
	private Person licenseHolder;
	@Override
	public String toString() {
		return "License [lid=" + lid + ", type=" + type + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}
	
	
	

}
