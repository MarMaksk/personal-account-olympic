package com.lk.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lk.backend.entity.enums.ERole;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users", indexes = {
        @Index(name = "idx_user_email_unq", columnList = "email", unique = true),
        @Index(name = "idx_user_username_unq", columnList = "username", unique = true)
})
public class User extends AbstractEntity implements UserDetails {

    @Column(nullable = false, unique = true)
    @JsonProperty("login")
    private String username;

    @Column(nullable = false)
    @Min(4)
    @Max(16)
    private String password;

    @Email
    @Column(unique = true)
    private String email;

    @ElementCollection(targetClass = ERole.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @ToString.Exclude
    private Set<ERole> roles = new HashSet<>();

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User(Long id, String email, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.setId(id);
        this.email = email;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
