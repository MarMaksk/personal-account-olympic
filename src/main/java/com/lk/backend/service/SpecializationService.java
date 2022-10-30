package com.lk.backend.service;

import com.lk.backend.dto.SpecializationDTO;
import com.lk.backend.repository.SpecializationRepository;
import com.lk.backend.service.mapper.SpecializationDTOMapper;

public class SpecializationService implements CRUD<SpecializationDTO> {

    SpecializationRepository repository;
    SpecializationDTOMapper mapper;

    @Override
    public void create(SpecializationDTO dto) {

    }

    @Override
    public SpecializationDTO find(String findBy) {
        return null;
    }

    @Override
    public SpecializationDTO update(SpecializationDTO dto) {
        return null;
    }

    @Override
    public void delete(SpecializationDTO dto) {

    }
}
