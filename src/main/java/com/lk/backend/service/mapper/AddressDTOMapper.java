package com.lk.backend.service.mapper;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.entity.Address;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressDTOMapper implements EntityToDTOMapper<Address, AddressDTO> {

    private final ModelMapper mapper;

    @Override
    public Address toEntity(AddressDTO dto) {
        return mapper.map(dto, Address.class);
    }

    @Override
    public AddressDTO toDTO(Address entity) {
        return mapper.map(entity, AddressDTO.class);
    }
}
