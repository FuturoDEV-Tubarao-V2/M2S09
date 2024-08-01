package com.futurodev.crm.service;

import com.futurodev.crm.dto.LeadRequestDto;
import com.futurodev.crm.dto.LeadResponseDto;
import org.springframework.data.domain.Page;

public interface LeadService {

    LeadResponseDto create(LeadRequestDto dto);
    LeadResponseDto update(Long id, LeadRequestDto dto);
    LeadResponseDto findById(Long id);
    Page<LeadResponseDto> findAll();
    void delete(Long id);

}
