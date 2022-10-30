package com.lk.backend.service.mapper;

import com.lk.backend.dto.PersonDTO;
import com.lk.backend.entity.Person;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonDTOMapper implements EntityToDTOMapper<Person, PersonDTO> {

    private final ModelMapper mapper;

    @Override
    public Person toEntity(PersonDTO dto) {
        return mapper.map(dto, Person.class);
    }

    @Override
    public PersonDTO toDTO(Person entity) {
        return mapper.map(entity, PersonDTO.class);
    }
}
