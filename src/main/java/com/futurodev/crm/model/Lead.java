package com.futurodev.crm.model;

import com.futurodev.crm.enumerated.LeadStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 150)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(length = 150)
    private String street;

    @Column(length = 50)
    private String neighborhood;

    @Column(length = 10)
    private String zipcode;

    @Column(length = 100)
    private String city;

    @Column(length = 50)
    private String state;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private LeadStatus status = LeadStatus.PENDING;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
