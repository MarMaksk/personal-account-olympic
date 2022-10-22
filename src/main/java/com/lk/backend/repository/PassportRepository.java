package com.lk.backend.repository;

import com.lk.backend.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PassportRepository extends JpaRepository<Passport, Long> {
}