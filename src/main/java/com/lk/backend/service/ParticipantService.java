package com.lk.backend.service;

import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.dto.PassportDTO;
import com.lk.backend.dto.PersonDTO;
import com.lk.backend.entity.Participant;
import com.lk.backend.exceptions.NoSuchInfoException;
import com.lk.backend.repository.ParticipantRepository;
import com.lk.backend.service.mapper.ParticipantDTOMapper;
import com.lk.backend.service.mapper.PassportDTOMapper;
import com.lk.backend.service.mapper.PersonDTOMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ParticipantService implements CRUD<ParticipantDTO> {

    ParticipantRepository repository;
    PassportService passportService;
    PassportDTOMapper passportDTOMapper;
    PersonDTOMapper personDTOMapper;
    ParticipantDTOMapper mapper;
    ModelMapper map;
    SDOUserService sdoUserService;

    @Override
    public ParticipantDTO create(ParticipantDTO dto) {
        Participant participant = mapper.toEntity(dto);
        if (dto.getPerson() != null && dto.getPerson().getPassport() != null) {
            passportService.create(dto.getPerson().getPassport());
            PassportDTO pass = passportService.find(participant.getPerson().getPassport().getIdentityNumber());
            participant
                    .getPerson()
                    .setPassport(passportDTOMapper.toEntity(pass));
        }
        if (dto.getLegalRepresentative() != null && dto.getLegalRepresentative().getPassport() != null) {
            PassportDTO passportDTO = passportService.create(dto.getLegalRepresentative().getPassport());
            log.error(passportDTO.toString());
            PassportDTO repPass = passportService.find(participant.getLegalRepresentative().getPassport().getIdentityNumber());
            log.error(repPass.toString());
            participant
                    .getLegalRepresentative()
                    .setPassport(passportDTOMapper.toEntity(passportDTO));
        }
        Participant save = repository.save(participant);
        return mapper.toDTO(save);
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

    @Transactional
    public void addLegalRepresentative(PersonDTO dto, String email) {
        Participant participant = repository.findByEmail(email).orElseThrow(NoSuchInfoException::new);
        System.out.println(participant.getLegalRepresentative());
        System.out.println(dto);
        participant.setLegalRepresentative(personDTOMapper.toEntity(dto));
        PassportDTO passportDTO = passportService.create(dto.getPassport());
        participant
                .getLegalRepresentative()
                .setPassport(passportDTOMapper.toEntity(passportDTO));
        System.out.println(participant.getLegalRepresentative());
        repository.save(participant);
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
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
