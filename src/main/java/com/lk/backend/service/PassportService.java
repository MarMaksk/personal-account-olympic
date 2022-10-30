package com.lk.backend.service;

import com.lk.backend.dto.PassportDTO;
import com.lk.backend.entity.Passport;
import com.lk.backend.exceptions.NoSuchInfoException;
import com.lk.backend.repository.PassportRepository;
import com.lk.backend.service.mapper.PassportDTOMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PassportService implements CRUD<PassportDTO> {

    PassportRepository repository;
    PassportDTOMapper mapper;
    ModelMapper modelMapper;

    Crypt crypt;


    @Override
    public void create(PassportDTO dto) {
        Passport passport = mapper.toEntity(dto);
        passport.setNumber(crypt.encrypt(dto.getNumber()));
        passport.setSeries(crypt.encrypt(dto.getSeries()));
        passport.setIdentityNumber(crypt.encrypt(dto.getIdentityNumber()));
        System.out.println(crypt.encrypt(dto.getIdentityNumber()));
        repository.save(passport);
    }

    @Override
    public PassportDTO find(String identityNumber) {
        Passport passport = repository.findByIdentityNumber(crypt.encrypt(identityNumber))
                .orElseThrow(NoSuchInfoException::new);
        PassportDTO passportDTO = mapper.toDTO(passport);
        passportDTO.setNumber(crypt.decrypt(passportDTO.getNumber()));
        passportDTO.setSeries(crypt.decrypt(passportDTO.getSeries()));
        passportDTO.setIdentityNumber(crypt.decrypt(passportDTO.getIdentityNumber()));
        return passportDTO;
    }

    public PassportDTO findBySeriesAndNumber(String series, String number) {
        Passport passport = repository.findBySeriesAndNumber(
                        crypt.encrypt(series), crypt.encrypt(number))
                .orElseThrow(NoSuchInfoException::new);
        PassportDTO passportDTO = mapper.toDTO(passport);
        passportDTO.setNumber(crypt.decrypt(passportDTO.getNumber()));
        passportDTO.setSeries(crypt.decrypt(passportDTO.getSeries()));
        passportDTO.setIdentityNumber(crypt.decrypt(passportDTO.getIdentityNumber()));
        return passportDTO;
    }

    @Override
    public PassportDTO update(PassportDTO dto) {
        Passport passport = repository.findByIdentityNumber(dto.getIdentityNumber()).orElseThrow(NoSuchInfoException::new);
        modelMapper.map(dto, passport);
        Passport save = repository.save(passport);
        return mapper.toDTO(save);
    }

    @Override
    public void delete(PassportDTO dto) {
        Passport passport = repository.findByIdentityNumber(dto.getIdentityNumber()).orElseThrow(NoSuchInfoException::new);
        repository.delete(passport);
    }
}
