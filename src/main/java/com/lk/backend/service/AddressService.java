package com.lk.backend.service;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.entity.Address;
import com.lk.backend.exceptions.NoSuchInfoException;
import com.lk.backend.repository.AddressRepository;
import com.lk.backend.service.mapper.AddressDTOMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AddressService implements CRUD<AddressDTO> {

    AddressRepository repository;
    AddressDTOMapper mapper;
    ModelMapper modelMapper;

    @Override
    public AddressDTO create(AddressDTO dto) {
        Address address = mapper.toEntity(dto);
        Address save = repository.save(address);
        return mapper.toDTO(save);
    }

    @Override
    public AddressDTO find(String id) {
        Address address = repository.findById(Long.valueOf(id)).orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(address);
    }

    @Override
    public AddressDTO update(AddressDTO dto) {
        Address address = repository.findById(dto.getId()).orElseThrow(NoSuchInfoException::new);
        modelMapper.map(dto, address);
        Address save = repository.save(address);
        return mapper.toDTO(save);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
