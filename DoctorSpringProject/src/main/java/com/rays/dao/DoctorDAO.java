package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import org.springframework.stereotype.Repository;

import com.rays.dto.DoctorDTO;

@Repository
public class DoctorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public long add(DoctorDTO dto) {
        entityManager.persist(dto);
        return dto.getId();
    }

    public void update(DoctorDTO dto) {
        entityManager.merge(dto);
    }

    public void delete(DoctorDTO dto) {
        entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
    }

    public DoctorDTO findByPk(long pk) {
        return entityManager.find(DoctorDTO.class, pk);
    }

    public List<DoctorDTO> search(DoctorDTO dto, int pageNo, int pageSize) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DoctorDTO> cq = builder.createQuery(DoctorDTO.class);
        Root<DoctorDTO> root = cq.from(DoctorDTO.class);

        List<Predicate> predicates = new ArrayList<>();

        if (dto.getName() != null && !dto.getName().isEmpty()) {
            predicates.add(builder.like(root.get("name"), dto.getName() + "%"));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<DoctorDTO> query = entityManager.createQuery(cq);

        if (pageSize > 0) {
            query.setFirstResult(pageNo * pageSize);
            query.setMaxResults(pageSize);
        }

        return query.getResultList();
    }
}
