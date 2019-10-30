package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProgrammerProjectInfo implements Serializable {
	private PrgmrProjId id;
	private String pname;
	private  String projName;

}
