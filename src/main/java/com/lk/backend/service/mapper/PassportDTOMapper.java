package com.lk.backend.service.mapper;

import com.lk.backend.dto.PassportDTO;
import com.lk.backend.entity.Passport;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PassportDTOMapper implements EntityToDTOMapper<Passport, PassportDTO> {

    private final ModelMapper mapper;

    @Override
    public Passport toEntity(PassportDTO dto) {
        return mapper.map(dto, Passport.class);
    }

    @Override
    public PassportDTO toDTO(Passport entity) {
        return mapper.map(entity, PassportDTO.class);
    }
}
