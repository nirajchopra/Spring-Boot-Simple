package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class DoctorForm {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Specialization is required")
    private String specialization;

    @NotEmpty(message = "Contact Number is required")
    private String contactNo;

    @Email(message = "Invalid email")
    @NotEmpty(message = "Email is required")
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
}
