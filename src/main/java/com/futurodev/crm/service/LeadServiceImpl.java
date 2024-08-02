package com.futurodev.crm.service;

import com.futurodev.crm.dto.LeadRequestDto;
import com.futurodev.crm.dto.LeadResponseDto;
import com.futurodev.crm.exception.error.NotFoundException;
import com.futurodev.crm.model.Lead;
import com.futurodev.crm.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;

    @Override
    public LeadResponseDto create(LeadRequestDto dto) {
        Lead lead = new Lead();
        BeanUtils.copyProperties(dto, lead);

        leadRepository.save(lead);

        return this.mapToResponse(lead);
    }

    @Override
    public LeadResponseDto update(Long id, LeadRequestDto dto) {
        Lead lead = this.findEntityById(id);
        BeanUtils.copyProperties(dto, lead);

        leadRepository.save(lead);

        return this.mapToResponse(lead);
    }

    @Override
    public LeadResponseDto findById(Long id) {
        Lead lead = this.findEntityById(id);
        return this.mapToResponse(lead);
    }

    @Override
    public Page<LeadResponseDto> findAll() {
        Page<Lead> leads = this.leadRepository.findAll(Pageable.unpaged());
        return leads.map(this::mapToResponse);
    }

    @Override
    public void delete(Long id) {
        Lead lead = this.findEntityById(id);
        this.leadRepository.delete(lead);
    }

    private Lead findEntityById(Long id) {
        return this.leadRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lead not found"));
    }

    private LeadResponseDto mapToResponse(Lead lead) {
        LeadResponseDto response = new LeadResponseDto();
        BeanUtils.copyProperties(lead, response);
        return response;
    }
}
