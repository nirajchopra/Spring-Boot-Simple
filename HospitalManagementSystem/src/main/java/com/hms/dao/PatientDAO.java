package com.hms.dao;

import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;

import org.springframework.stereotype.Repository;
import com.hms.dto.PatientDTO;

@Repository
public class PatientDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public long add(PatientDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(PatientDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(PatientDTO dto) {
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	public PatientDTO findByPk(long pk) {
		return entityManager.find(PatientDTO.class, pk);
	}

	public List<PatientDTO> search(PatientDTO dto, int pageNo, int pageSize) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PatientDTO> cq = builder.createQuery(PatientDTO.class);
		Root<PatientDTO> root = cq.from(PatientDTO.class);

		List<Predicate> predicates = new ArrayList<>();

		if (dto.getName() != null && !dto.getName().isEmpty()) {
			predicates.add(builder.like(root.get("name"), dto.getName() + "%"));
		}

		cq.where(predicates.toArray(new Predicate[0]));

		TypedQuery<PatientDTO> query = entityManager.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		return query.getResultList();
	}
}
