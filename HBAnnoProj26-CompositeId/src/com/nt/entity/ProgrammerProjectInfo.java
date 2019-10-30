package com.nt.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PROGRAMMERS_PROJECTS")
public class ProgrammerProjectInfo implements Serializable {
	@EmbeddedId
	private PrgmrProjId id;
	private String pname;
	private  String projName;

}
