package com.airbnb.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String address;
    private BigDecimal pricePerNight;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private boolean available;
    private boolean drinkAllowed;
    private boolean petAllowed;
    private int maxCheckoutTimeInNights;
    private BigDecimal extraCharges;

//    @OneToMany(mappedBy = "property")
//    private List<Review> reviews;

    @ManyToOne()
    @JsonBackReference
    private User owner;

}


