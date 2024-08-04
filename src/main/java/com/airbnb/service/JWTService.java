package com.airbnb.service;

import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;

@Service
public class JWTService {


    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails);
    }
    }

