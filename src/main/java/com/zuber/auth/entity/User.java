package com.zuber.auth.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "User_Table")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "Username can't be  Blank")
    @Column(unique = true)
    private String userName;
    @NotBlank(message = "Name can't be  Blank")
    @Column(unique = true)
    private String name;

    @Column(unique = true)
    @NotBlank(message = "password can't be  Blank")
    @Size(min = 5,message = "Password should be more then 5 letters")
    private String password;

    @Column(unique = true)
    @NotBlank(message = "email can't be  Blank")
    private String email;


    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToOne(mappedBy = "user")
    private RefreshToken refreshToken;

    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
