package com.futurodev.crm.dto;

import com.futurodev.crm.enumerated.LeadStatus;
import lombok.Data;

@Data
public class LeadResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private LeadStatus status;
}
