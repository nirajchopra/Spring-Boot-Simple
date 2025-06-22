package com.rays.ctl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hms.common.BaseController;
import com.hms.common.ORSResponse;
import com.hms.dto.DoctorDTO;
import com.hms.form.DoctorForm;
import com.hms.service.DoctorService;

@RestController
@RequestMapping("Doctor")
public class DoctorCtl extends BaseController {

	@Autowired
	private DoctorService service;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid DoctorForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess())
			return res;

		DoctorDTO dto = new DoctorDTO();
		dto.setName(form.getName());
		dto.setSpecialization(form.getSpecialization());
		dto.setContactNo(form.getContactNo());
		dto.setEmail(form.getEmail());

		long pk = service.save(dto);
		res.addData(pk);
		res.addMessage("Doctor saved successfully!");
		return res;
	}
}
