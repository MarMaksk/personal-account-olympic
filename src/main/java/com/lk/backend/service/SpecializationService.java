package com.lk.backend.service;

import com.lk.backend.dto.SpecializationDTO;
import com.lk.backend.entity.Specialization;
import com.lk.backend.exceptions.NoSuchInfoException;
import com.lk.backend.repository.SpecializationRepository;
import com.lk.backend.service.mapper.SpecializationDTOMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SpecializationService implements CRUD<SpecializationDTO> {

    SpecializationRepository repository;
    SpecializationDTOMapper mapper;
    ModelMapper modelMapper;

    @Override
    public SpecializationDTO create(SpecializationDTO dto) {
        Specialization specialization = mapper.toEntity(dto);
        Specialization save = repository.save(specialization);
        return mapper.toDTO(save);
    }

    @Override
    public SpecializationDTO find(String code) {
        Specialization specialization = repository.findByCode(code).orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(specialization);
    }

    @Override
    public SpecializationDTO update(SpecializationDTO dto) {
        Specialization specialization = repository.findByCode(dto.getCode()).orElseThrow(NoSuchInfoException::new);
        modelMapper.map(dto, specialization);
        Specialization save = repository.save(specialization);
        return mapper.toDTO(save);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<SpecializationDTO> findAll() {
        return mapper.toDTOs(repository.findAll());
    }
}
