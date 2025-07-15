package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.DoctorDTO;
import com.rays.form.DoctorForm;
import com.rays.service.DoctorService;

@RestController
@RequestMapping("Doctor")
public class DoctorCtl {

	@Autowired
	private DoctorService service;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid DoctorForm form) {
	    ORSResponse res = new ORSResponse(true);

	    DoctorDTO dto = new DoctorDTO();
	    dto.setName(form.getName());
	    dto.setSpecialization(form.getSpecialization());
	    dto.setContactNo(form.getContactNo());
	    dto.setEmail(form.getEmail());

	    System.out.println("Saving doctor: " + dto.getName()); // Debug line

	    long pk = service.save(dto);
	    res.addData(pk);
	    res.addMessage("Doctor saved successfully!");
	    return res;
	}

	@GetMapping("{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse(true);
		DoctorDTO dto = service.findById(id);
		res.addData(dto);
		return res;
	}

	@DeleteMapping("{id}")
	public ORSResponse delete(@PathVariable long id) {
		service.delete(id);
		ORSResponse res = new ORSResponse(true);
		res.addMessage("Doctor deleted successfully!");
		return res;
	}
}
