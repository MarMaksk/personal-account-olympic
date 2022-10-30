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

    AddressRepository addressRepository;
    AddressDTOMapper mapper;
    ModelMapper modelMapper;

    @Override
    public void create(AddressDTO dto) {
        Address address = mapper.toEntity(dto);
        addressRepository.save(address);
    }

    @Override
    public AddressDTO find(String id) {
        Address address = addressRepository.findById(Long.valueOf(id)).orElseThrow(NoSuchInfoException::new);
        return mapper.toDTO(address);
    }

    @Override
    public AddressDTO update(AddressDTO dto) {
        Address address = addressRepository.findById(dto.getId()).orElseThrow(NoSuchInfoException::new);
        modelMapper.map(dto, address);
        Address save = addressRepository.save(address);
        return mapper.toDTO(save);
    }

    @Override
    public void delete(AddressDTO dto) {
        Address address = addressRepository.findById(dto.getId()).orElseThrow(NoSuchInfoException::new);
        addressRepository.delete(address);
    }
}
