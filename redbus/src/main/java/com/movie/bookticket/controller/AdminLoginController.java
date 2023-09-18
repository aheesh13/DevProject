package com.movie.bookticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movie.bookticket.useradminmodel.Admin;
import com.movie.bookticket.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminLoginController {
	private final AuthenticationManager am;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);

    @Autowired
    public AdminLoginController(AuthenticationManager am, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.am = am;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody Admin adminCredentials) {
        // Authenticate the admin user using the UserDetails created in SecurityConfig
        logger.info("Received login request for username: {}", adminCredentials.getUsername());

        UserDetails adminUser = userDetailsService.loadUserByUsername("admin");

        if (adminUser != null) {
            logger.info("Stored hashed password: {}", adminUser.getPassword());

            // Compare the provided plaintext password with the stored hashed password
            if (passwordEncoder.matches(adminCredentials.getPassword(), adminUser.getPassword())) {
                // Authentication successful
                Authentication authentication = new UsernamePasswordAuthenticationToken(adminUser, null, adminUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                logger.info("Admin logged in successfully");

                return ResponseEntity.ok("Admin logged in successfully");
            }
        }
        logger.warn("Failed login attempt for username: {}", adminCredentials.getUsername());

        // Failed login attempt
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin credentials");
    }
}

