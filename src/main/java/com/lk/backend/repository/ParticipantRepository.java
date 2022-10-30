package com.lk.backend.repository;

import com.lk.backend.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {


    Optional<Participant> findByEmail(String email);

    Optional<Participant> findByPersonPassportIdentityNumber(String identityPassportNumber);

    Optional<Participant> findByPersonPassportSeriesAndPersonPassportNumber(String series, String number);
    Optional<Participant> findByPersonPassportId(Long id);

}