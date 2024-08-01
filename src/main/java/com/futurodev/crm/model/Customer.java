package com.futurodev.crm.model;

import com.futurodev.crm.enumerated.LeadStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String phone;

    @Column(length = 150, nullable = false)
    private String street;

    @Column(length = 50, nullable = false)
    private String neighborhood;

    @Column(length = 10, nullable = false)
    private String zipcode;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String state;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private LeadStatus status;

    @Column(nullable = false)
    private boolean isActive = true;

}
