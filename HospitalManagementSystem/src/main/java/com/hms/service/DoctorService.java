package com.hms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import com.hms.dao.DoctorDAO;
import com.hms.dto.DoctorDTO;

@Service
@Transactional
public class DoctorService {

	@Autowired
	private DoctorDAO dao;

	public long add(DoctorDTO dto) {
		return dao.add(dto);
	}

	public void update(DoctorDTO dto) {
		dao.update(dto);
	}

	public void delete(long id) {
		DoctorDTO dto = findById(id);
		dao.delete(dto);
	}

	public DoctorDTO findById(long id) {
		return dao.findByPk(id);
	}

	public long save(DoctorDTO dto) {
		if (dto.getId() != null && dto.getId() > 0) {
			update(dto);
			return dto.getId();
		} else {
			return add(dto);
		}
	}

	public List<DoctorDTO> search(DoctorDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
}
