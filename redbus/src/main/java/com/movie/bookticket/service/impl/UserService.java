package com.movie.bookticket.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.movie.bookticket.repository.UserRepository;
import com.movie.bookticket.useradminmodel.User;
import com.movie.bookticket.util.UserAlreadyExistsException;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String password) {
        // Check if the user with the same username already exists
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User with the same username already exists");
        }

        // Create a new user
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles("USER"); // Assign a default role for new users

        return userRepository.save(user);
    }


    public User getUserByUsername(String username) {
        User user =  userRepository.findByUsername(username);
        if(user!=null) {
        	throw new UsernameNotFoundException("User not found with username: " + username);
        }
		return user;
    }

    // Other methods for user management
}
