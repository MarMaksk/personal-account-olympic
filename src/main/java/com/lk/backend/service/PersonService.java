package com.lk.backend.service;

import com.lk.backend.dto.PersonDTO;
import com.lk.backend.entity.Person;
import com.lk.backend.exceptions.NoSuchInfoException;
import com.lk.backend.repository.PersonRepository;
import com.lk.backend.service.mapper.PersonDTOMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PersonService implements CRUD<PersonDTO> {

    PersonRepository repository;
    PassportService passportService;
    PersonDTOMapper mapper;
    ModelMapper modelMapper;

    @Override
    public void create(PersonDTO dto) {
        if (dto.getPassport() != null)
            passportService.create(dto.getPassport());
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public PersonDTO find(String id) {
        Person person = repository.findById(Long.valueOf(id)).orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(person);
    }

    public PersonDTO findByFio(String firstname, String secondName, String lastname) {
        Person person = repository
                .findByFirstNameAndSecondNameAndLastName(firstname, secondName, lastname)
                .orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(person);
    }

    @Override
    public PersonDTO update(PersonDTO dto) {
        Person person = repository.findById(dto.getId()).orElseThrow(NoSuchInfoException::new);
        modelMapper.map(dto, person);
        Person save = repository.save(person);
        return mapper.toDTO(save);
    }

    @Override
    public void delete(PersonDTO dto) {
        Person person = repository.findById(dto.getId()).orElseThrow(NoSuchInfoException::new);
        repository.delete(person);
    }
}
