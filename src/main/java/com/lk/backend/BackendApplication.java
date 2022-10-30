package com.lk.backend;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.dto.PassportDTO;
import com.lk.backend.dto.PersonDTO;
import com.lk.backend.entity.Participant;
import com.lk.backend.service.mapper.ParticipantDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class BackendApplication {

    @Autowired
    ParticipantDTOMapper participantDTOMapper;

    @PostConstruct
    public void test() {
        ParticipantDTO dto = new ParticipantDTO(
                new PersonDTO("Maxim", "Maximov", "Maximovich",
                        new PassportDTO("BM", "1234567", "12345678901234")),
                new Date(2222, Calendar.MARCH, 2),
                new AddressDTO("RB", "BB", "VV", "Mikhailov", 1, 1, 1),
                "ygi",
                "This",
                new PersonDTO("Maxim's", "Maximov's", "Maximovich's",
                        new PassportDTO("BM", "1234566", "12345678901233")),
                new HashSet<>()
        );
        Participant participant = participantDTOMapper.toEntity(dto);
        System.out.println(participant);
        // TODO: 23.10.2022 Проверить парсинг из ДТО в entity и обратно для Participant
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

    }

}
