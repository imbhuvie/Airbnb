package com.airbnb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required.")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be atleast 8 character.")
    private String password;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Full name is required.")
    private String fullName;

    @NotBlank(message = "Password is required.")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Property> properties;

//    @OneToMany(mappedBy = "user")
//    private List<Review> reviews;
}



