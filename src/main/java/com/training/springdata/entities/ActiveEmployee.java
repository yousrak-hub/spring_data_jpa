package com.training.springdata.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table
public class ActiveEmployee extends Employee{
	@Column
	private int e_salary;  
	@Column
    private int e_experience;  
	public ActiveEmployee() {
		super();
	}
	public int getE_salary() {
		return e_salary;
	}
	public void setE_salary(int e_salary) {
		this.e_salary = e_salary;
	}
	public int getE_experience() {
		return e_experience;
	}
	public void setE_experience(int e_experience) {
		this.e_experience = e_experience;
	}

}
