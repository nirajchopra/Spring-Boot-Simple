package com.hms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hms.common.BaseDTO;

@Entity
@Table(name = "ST_DOCTOR")
public class DoctorDTO extends BaseDTO {

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "SPECIALIZATION", length = 50)
	private String specialization;

	@Column(name = "CONTACT_NO", length = 15)
	private String contactNo;

	@Column(name = "EMAIL", length = 100)
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getValue() {
		return name;
	}
}
