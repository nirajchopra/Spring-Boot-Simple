package com.rays.form;

import javax.validation.constraints.*;
import com.hms.common.BaseForm;

public class PatientForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;

	@Min(value = 0, message = "Age must be positive")
	private int age;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "Address is required")
	private String address;

	// ✅ Getters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	// ✅ Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
