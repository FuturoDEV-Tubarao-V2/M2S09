package com.futurodev.crm.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LeadStatus {

    PENDING("Pending"),
    APPROVED("Approved"),
    REFUSED("Refused");

    private final String description;

}
