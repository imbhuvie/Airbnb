package com.airbnb.service;

import com.airbnb.model.User;
import com.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String verify(User user) {
        Authentication authentication=
                authenticationManager.authenticate((
                        new UsernamePasswordAuthenticationToken(
                                user.getUsername(),user.getPassword())));
        if(authentication.isAuthenticated()){
        return jwtService.generateToken(user.getUsername());
        }
        else return "Failed to login";
    }

    public User getUser(int id) {
        return userRepository.findById((long) id).orElse(null);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
