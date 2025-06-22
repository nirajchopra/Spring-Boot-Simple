package com.hms.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.common.BaseController;
import com.hms.common.ORSResponse;
import com.hms.dto.RoleDTO;
import com.hms.form.RoleForm;
import com.hms.service.RoleService;

@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseController {

	@Autowired
	public RoleService roleService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		RoleDTO dto = new RoleDTO();
		dto.setName(form.getName());
		dto.setDescription(form.getDescription());

		long pk = roleService.add(dto);

		res.addData(pk);
		res.addMessage("Role addedd successfully..!!!");

		return res;

	}

}
