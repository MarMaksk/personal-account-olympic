package com.lk.backend.service;

import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.dto.PassportDTO;
import com.lk.backend.entity.Participant;
import com.lk.backend.exceptions.NoSuchInfoException;
import com.lk.backend.repository.ParticipantRepository;
import com.lk.backend.repository.PassportRepository;
import com.lk.backend.service.mapper.ParticipantDTOMapper;
import com.lk.backend.service.mapper.PassportDTOMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ParticipantService implements CRUD<ParticipantDTO> {

    ParticipantRepository repository;
    PassportService passportService;
    PassportDTOMapper passportDTOMapper;
    ParticipantDTOMapper mapper;
    ModelMapper map;
    SDOUserService sdoUserService;

    @Override
    public void create(ParticipantDTO dto) {
        Participant participant = mapper.toEntity(dto);
        if (dto.getPerson().getPassport() != null) {
            passportService.create(dto.getPerson().getPassport());
            PassportDTO pass = passportService.find(participant.getPerson().getPassport().getIdentityNumber());
            participant
                    .getPerson()
                    .setPassport(passportDTOMapper.toEntity(pass));
        }
        if (dto.getLegalRepresentative().getPassport() != null) {
            passportService.create(dto.getLegalRepresentative().getPassport());
            PassportDTO repPass = passportService.find(participant.getLegalRepresentative().getPassport().getIdentityNumber());
            participant
                    .getLegalRepresentative()
                    .setPassport(passportDTOMapper.toEntity(repPass));
        }
        repository.save(participant);
    }

    @Override
    public ParticipantDTO find(String email) {
        Participant participant = repository.findByEmail(email).orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(participant);
    }

    public ParticipantDTO findByPassportNumber(String series, String number) {
        PassportDTO pass = passportService.findBySeriesAndNumber(series, number);
        Participant participant = repository.findByPersonPassportId(pass.getId()).orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(participant);
    }

    public ParticipantDTO findByPassportIdentityNumber(String identityNumber) {
        PassportDTO pass = passportService.find(identityNumber);
        Participant participant = repository.findByPersonPassportId(pass.getId()).orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(participant);
    }

    @Override
    public ParticipantDTO update(ParticipantDTO dto) {
        Participant entity = repository.findByEmail(dto.getEmail()).orElseThrow(NoSuchInfoException::new);
        Participant participant = mapper.toEntity(dto);
        map.map(participant, entity);
        Participant save = repository.save(entity);
        return mapper.toDTO(save);
    }

    @Override
    public void delete(ParticipantDTO dto) {
        Participant participant = repository.findByEmail(dto.getEmail()).orElseThrow(NoSuchInfoException::new);
        repository.delete(participant);
    }
}
