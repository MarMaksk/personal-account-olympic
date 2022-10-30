package com.lk.backend.repository;

import com.lk.backend.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassportRepository extends JpaRepository<Passport, Long> {

    Optional<Passport> findBySeriesAndNumber(String series, String number);
    Optional<Passport> findByIdentityNumber(String identityNumber);

}