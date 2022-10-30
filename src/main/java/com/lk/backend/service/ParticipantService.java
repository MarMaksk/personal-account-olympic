package com.lk.backend.service;

import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.entity.Participant;
import com.lk.backend.exceptions.NoSuchParticipantException;
import com.lk.backend.repository.ParticipantRepository;
import com.lk.backend.service.mapper.ParticipantDTOMapper;
import org.modelmapper.ModelMapper;

public class ParticipantService implements CRUD<ParticipantDTO> {

    ParticipantRepository repository;
    ParticipantDTOMapper mapper;
    ModelMapper map;

    @Override
    public void create(ParticipantDTO dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public ParticipantDTO find(String email) {
        Participant participant = repository.findByEmail(email).orElseThrow(NoSuchParticipantException::new);
        return mapper.toDTO(participant);
    }

    public ParticipantDTO findByPassportNumber(String series, String number) {

    }

    public ParticipantDTO findByPassportIdentityNumber(String identityNumber) {

    }

    @Override
    public ParticipantDTO update(ParticipantDTO dto) {
        Participant entity = repository.findByEmail(dto.getEmail()).orElseThrow(NoSuchParticipantException::new);
        Participant participant = mapper.toEntity(dto);
        map.map(participant, entity);
        Participant save = repository.save(entity);
        return mapper.toDTO(save);
    }

    @Override
    public void delete(ParticipantDTO dto) {
        Participant participant = repository.findByEmail(dto.getEmail()).orElseThrow(NoSuchParticipantException::new);
        repository.delete(participant);
    }
}
