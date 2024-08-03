package com.futurodev.crm.controller;

import com.futurodev.crm.dto.LeadRequestDto;
import com.futurodev.crm.dto.LeadResponseDto;
import com.futurodev.crm.service.LeadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("leads")
public class LeadController {

    private final LeadService leadService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public LeadResponseDto create(@RequestBody LeadRequestDto dto) {
        log.info("Creating Lead: {}", "/leads");
        LeadResponseDto lead = leadService.create(dto);

        log.info("Created Lead: {}", "/leads");
        return lead;
    }

    @PutMapping("{id}")
    public LeadResponseDto update(@PathVariable Long id, @RequestBody LeadRequestDto dto) {
        log.info("Editing Lead: /lead/{}", id);
        LeadResponseDto lead = leadService.update(id, dto);

        log.info("Edited Lead: /lead/{}", id);
        return lead;
    }

    @GetMapping
    public Page<LeadResponseDto> findAll() {
        log.info("Getting all Leads: {}", "/leads");
        Page<LeadResponseDto> lead = leadService.findAll();

        log.info("Got all Leads: {}", "/leads");
        return lead;
    }

    @GetMapping("{id}")
    public LeadResponseDto findById(@PathVariable Long id) {
        log.info("Getting Lead: /lead/{}", id);
        LeadResponseDto lead = leadService.findById(id);

        log.info("Got Lead: /lead/{}", id);
        return lead;
    }

    //    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        log.info("Deleting Lead: /lead/{}", id);
        leadService.delete(id);

        log.info("Deleted Lead: /lead/{}", id);
        return ResponseEntity.noContent().build();
    }

}
