package com.lk.backend.service;

import com.lk.backend.entity.SDOUser;
import com.lk.backend.exceptions.NoSuchInfoException;
import com.lk.backend.repository.SDOUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SDOUserService {

    SDOUserRepository repository;
    ModelMapper modelMapper;

    @Transactional
    public SDOUser create(String username,
                          String specializationCode,
                          String birthdayYear,
                          String passportNumber) throws Exception {
        SDOUser sdoUser = new SDOUser();
        String concat = birthdayYear + passportNumber;
        List<Character> collect = concat.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(collect);
        StringBuilder login = new StringBuilder();
        login.append(username).append(specializationCode).append(birthdayYear);
        for (Character character : collect) {
            login.append(character.charValue());
        }
        sdoUser.setLogin(String.valueOf(login));
        sdoUser.setPassword(String.valueOf(login));
        return repository.save(sdoUser);
    }

    @Transactional
    public SDOUser find(String login) {
        return repository.findByLogin(login).orElseThrow(NoSuchInfoException::new);
    }

    @Transactional
    public SDOUser update(SDOUser user) {
        SDOUser sdoUser = repository.findByLogin(user.getLogin()).orElseThrow(NoSuchInfoException::new);
        modelMapper.map(user, sdoUser);
        return repository.save(sdoUser);
    }

    @Transactional
    public void delete(SDOUser user) {
        repository.delete(user);
    }
}
