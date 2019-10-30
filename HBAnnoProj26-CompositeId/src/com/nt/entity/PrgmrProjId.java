package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PrgmrProjId implements Serializable {
	private int projId;
	private int pid;

}
