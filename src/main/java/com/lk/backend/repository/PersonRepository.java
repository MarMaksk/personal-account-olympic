package com.lk.backend.repository;

import com.lk.backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstNameAndSecondNameAndLastName(String firstName, String secondName, String lastName);
}