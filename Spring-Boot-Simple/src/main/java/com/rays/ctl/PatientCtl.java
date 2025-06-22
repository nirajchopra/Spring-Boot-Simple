package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.common.BaseController;
import com.hms.common.ORSResponse;
import com.hms.dto.PatientDTO;
import com.hms.form.PatientForm;
import com.hms.service.PatientService;

@RestController
@RequestMapping("Patient")
public class PatientCtl extends BaseController {

	@Autowired
	private PatientService service;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid PatientForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess())
			return res;

		PatientDTO dto = new PatientDTO();
		dto.setName(form.getName());
		dto.setAge(form.getAge());
		dto.setGender(form.getGender());
		dto.setAddress(form.getAddress());

		long pk = service.save(dto);
		res.addData(pk);
		res.addMessage("Patient saved successfully!");
		return res;
	}
}
