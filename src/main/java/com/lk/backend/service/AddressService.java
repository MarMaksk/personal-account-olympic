package com.lk.backend.service;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.repository.AddressRepository;
import com.lk.backend.service.mapper.AddressDTOMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AddressService implements CRUD<AddressDTO> {

    AddressRepository addressRepository;
    AddressDTOMapper mapper;

    @Override
    public void create(AddressDTO dto) {

    }

    @Override
    public AddressDTO find(String code) {
        return null;
    }

    @Override
    public AddressDTO update(AddressDTO dto) {
        return null;
    }

    @Override
    public void delete(AddressDTO dto) {
        addressRepository.delete(mapper.toEntity(dto));
    }
}
