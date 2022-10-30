package com.lk.backend.service.mapper;

import com.lk.backend.dto.SpecializationDTO;
import com.lk.backend.entity.Specialization;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SpecializationDTOMapper implements EntityToDTOMapper<Specialization, SpecializationDTO> {

    private final ModelMapper mapper;
    @Override
    public Specialization toEntity(SpecializationDTO dto) {
        return mapper.map(dto, Specialization.class);
    }

    @Override
    public SpecializationDTO toDTO(Specialization entity) {
        return mapper.map(entity, SpecializationDTO.class);
    }
}
