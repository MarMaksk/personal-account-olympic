package com.lk.backend.service.mapper;

import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.entity.Participant;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ParticipantDTOMapper implements EntityToDTOMapper<Participant, ParticipantDTO> {
    private final ModelMapper mapper;

    @Override
    public Participant toEntity(ParticipantDTO dto) {
        return mapper.map(dto, Participant.class);
    }

    @Override
    public ParticipantDTO toDTO(Participant entity) {
        return mapper.map(entity, ParticipantDTO.class);
    }
}
