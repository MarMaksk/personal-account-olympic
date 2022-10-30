package com.lk.backend.service;

import com.lk.backend.dto.PersonDTO;
import com.lk.backend.repository.PersonRepository;
import com.lk.backend.service.mapper.PersonDTOMapper;

public class PersonService implements CRUD<PersonDTO> {

    PersonRepository repository;
    PersonDTOMapper mapper;

    @Override
    public void create(PersonDTO dto) {

    }

    @Override
    public PersonDTO find(String findBy) {
        return null;
    }

    @Override
    public PersonDTO update(PersonDTO dto) {
        return null;
    }

    @Override
    public void delete(PersonDTO dto) {

    }
}
