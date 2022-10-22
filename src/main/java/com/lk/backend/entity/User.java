package com.lk.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users", indexes = {
        @Index(name = "idx_user_email_unq", columnList = "email", unique = true),
        @Index(name = "idx_user_login_unq", columnList = "login", unique = true)
})
public class User extends AbstractEntity {

    @Column(unique = true)
    private String login;

    private String password;

    @Email
    @Column(unique = true)
    private String email;

}
