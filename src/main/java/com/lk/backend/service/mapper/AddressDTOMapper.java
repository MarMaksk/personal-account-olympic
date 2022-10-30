package com.lk.backend.service.mapper;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.entity.Address;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressDTOMapper implements EntityToDTOMapper<Address, AddressDTO> {

    private final ModelMapper modelMapper;

    @Override
    public Address toEntity(AddressDTO dto) {
        return modelMapper.map(dto, Address.class);
    }

    @Override
    public AddressDTO toDTO(Address entity) {
        return modelMapper.map(entity, AddressDTO.class);
    }
}
