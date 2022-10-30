package com.lk.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class SDOUser extends AbstractEntity {

    private String login;

    private String password;
}
