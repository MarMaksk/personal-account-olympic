package com.lk.backend.service.mapper;

import com.lk.backend.dto.UserDTO;
import com.lk.backend.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDTOMapper implements EntityToDTOMapper<User, UserDTO> {

    static Logger LOG = LoggerFactory.getLogger(UserDTOMapper.class);
    private final ModelMapper mapper;

    public User toEntity(UserDTO dto) {
        LOG.info("UserDTOMapper.toEntity()");
        return mapper.map(dto, User.class);
    }

    public UserDTO toDTO(User entity) {
        LOG.info("UserDTOMapper.toDTO()");
        return mapper.map(entity, UserDTO.class);
    }
}
