package com.hms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.hms.common.BaseDTO;

@Entity
@Table(name = "ST_PATIENT")
public class PatientDTO extends BaseDTO {

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "AGE")
	private int age;

	@Column(name = "GENDER", length = 10)
	private String gender;

	@Column(name = "ADDRESS", length = 200)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getValue() {
		return name;
	}
}
