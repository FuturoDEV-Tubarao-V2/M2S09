package com.futurodev.crm.service;

import com.futurodev.crm.dto.LeadRequestDto;
import com.futurodev.crm.dto.LeadResponseDto;
import com.futurodev.crm.exception.error.NotFoundException;
import com.futurodev.crm.model.Lead;
import com.futurodev.crm.repository.LeadRepository;
import com.futurodev.crm.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;

    @Override
    public LeadResponseDto create(LeadRequestDto dto) {
        log.debug("Creating Lead from DTO {}", JsonUtil.toJson(dto));
        Lead lead = new Lead();
        BeanUtils.copyProperties(dto, lead);

        leadRepository.save(lead);

        LeadResponseDto response = this.mapToResponse(lead);
        log.debug("Created Lead: {}", JsonUtil.toJson(response));
        return response;
    }

    @Override
    public LeadResponseDto update(Long id, LeadRequestDto dto) {
        log.debug("Editing Lead ({}) from DTO {}", id, JsonUtil.toJson(dto));
        Lead lead = this.findEntityById(id);
        BeanUtils.copyProperties(dto, lead);

        leadRepository.save(lead);

        LeadResponseDto response = this.mapToResponse(lead);
        log.debug("Edited Lead ({}): {}", id, JsonUtil.toJson(response));
        return response;
    }

    @Override
    public LeadResponseDto findById(Long id) {
        log.debug("Getting Lead ({})", id);
        Lead lead = this.findEntityById(id);

        LeadResponseDto response = this.mapToResponse(lead);
        log.debug("Got Lead ({}): {}", id, JsonUtil.toJson(response));
        return response;
    }

    @Override
    public Page<LeadResponseDto> findAll() {
        log.debug("Getting all Leads");
        Page<Lead> leads = this.leadRepository.findAll(Pageable.unpaged());

        Page<LeadResponseDto> response = leads.map(this::mapToResponse);
        log.debug("Got all Leads: {}", JsonUtil.toJson(response));
        return response;
    }

    @Override
    public void delete(Long id) {
        log.debug("Deleting Lead ({})", id);
        Lead lead = this.findEntityById(id);
        this.leadRepository.delete(lead);
        log.debug("Deleted Lead ({})", id);
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
