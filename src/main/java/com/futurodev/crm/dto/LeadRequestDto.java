package com.futurodev.crm.dto;

import lombok.Data;

@Data
public class LeadRequestDto {

    private String name;
    private String email;
    private String phone;
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;

}
