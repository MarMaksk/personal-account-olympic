package com.lk.backend;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.dto.PassportDTO;
import com.lk.backend.dto.PersonDTO;
import com.lk.backend.entity.Participant;
import com.lk.backend.service.ParticipantService;
import com.lk.backend.service.SDOUserService;
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
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

    }

}
