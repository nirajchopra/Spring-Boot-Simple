package com.rays.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import com.hms.dao.PatientDAO;
import com.hms.dto.PatientDTO;

@Service
@Transactional
public class PatientService {

	@Autowired
	private PatientDAO dao;

	public long add(PatientDTO dto) {
		return dao.add(dto);
	}

	public void update(PatientDTO dto) {
		dao.update(dto);
	}

	public void delete(long id) {
		PatientDTO dto = findById(id);
		dao.delete(dto);
	}

	public PatientDTO findById(long id) {
		return dao.findByPk(id);
	}

	public long save(PatientDTO dto) {
		if (dto.getId() != null && dto.getId() > 0) {
			update(dto);
			return dto.getId();
		} else {
			return add(dto);
		}
	}

	public List<PatientDTO> search(PatientDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
}
