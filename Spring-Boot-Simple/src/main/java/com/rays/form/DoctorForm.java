package com.rays.form;

import javax.validation.constraints.*;

import com.hms.common.BaseForm;

public class DoctorForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Specialization is required")
	private String specialization;

	@NotEmpty(message = "Contact Number is required")
	private String contactNo;

	@Email(message = "Invalid email")
	@NotEmpty(message = "Email is required")
	private String email;

	// ✅ Getters
	public String getName() {
		return name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getEmail() {
		return email;
	}

	// ✅ Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
