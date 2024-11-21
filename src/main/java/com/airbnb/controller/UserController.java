package com.airbnb.controller;

import com.airbnb.model.User;
import com.airbnb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

//    Username and password send by body.
//    {
//          "username":"navya",
//          "password":"Navya@123"
//     }

    @Autowired
    UserService userService;
//
//    @GetMapping("/csrf-token")
//    public CsrfToken getCrsfToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }
//--------------------------------------------------------------------------------------
//    Signup API :
//    {
//        "username": "bhuvie",
//        "password": "Bhuvie@123",
//        "email": "bhuvie@gmail.com",
//        "fullName": "Bhupendra Verma",
//        "phoneNumber": "7865432536"
//    }
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody User user){
        try {
            userService.register(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
//---------------------------------------------------------------------------------------------
//    Login API :
//    {
//        "username":"bhuvie",
//        "password":"Bhuvie@123"
//      }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }
}
