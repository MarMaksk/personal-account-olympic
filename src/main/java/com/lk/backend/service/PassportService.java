package com.lk.backend.service;

import com.lk.backend.dto.PassportDTO;
import com.lk.backend.repository.PassportRepository;
import com.lk.backend.service.mapper.PassportDTOMapper;

public class PassportService implements CRUD<PassportDTO> {

    PassportRepository repository;
    PassportDTOMapper mapper;

    @Override
    public void create(PassportDTO dto) {

    }

    @Override
    public PassportDTO find(String findBy) {
        return null;
    }

    @Override
    public PassportDTO update(PassportDTO dto) {
        return null;
    }

    @Override
    public void delete(PassportDTO dto) {

    }
}
