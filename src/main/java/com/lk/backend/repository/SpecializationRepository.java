package com.lk.backend.repository;

import com.lk.backend.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}