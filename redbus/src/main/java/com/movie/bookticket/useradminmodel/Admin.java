package com.movie.bookticket.useradminmodel;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Admin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(name = "user_password")
    private String password;

    // Other fields and getters/setters...

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return a collection of roles or authorities (e.g., "ROLE_ADMIN")
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
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
        return true; // Set to true if the account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Set to true if the account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Set to true if the credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Set to true if the account is enabled
    }

    // Implement other UserDetails methods...

}
