package com.training.springdata.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RetiredEmployee extends Employee {
	@Column
	private int e_pension;

	public RetiredEmployee() {
		super();
	}

	public int getE_pension() {
		return e_pension;
	}

	public void setE_pension(int e_pension) {
		this.e_pension = e_pension;
	}
}
