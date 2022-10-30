package com.lk.backend.repository;

import com.lk.backend.entity.SDOUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SDOUserRepository extends JpaRepository<SDOUser, Long> {

        Optional<SDOUser> findByLogin(String login);
}
