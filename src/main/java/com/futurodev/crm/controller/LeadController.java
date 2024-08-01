package com.futurodev.crm.controller;

import com.futurodev.crm.dto.LeadRequestDto;
import com.futurodev.crm.dto.LeadResponseDto;
import com.futurodev.crm.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("leads")
public class LeadController {

    private final LeadService leadService;

    @PostMapping()
    public LeadResponseDto create(@RequestBody LeadRequestDto dto) {
        return leadService.create(dto);
    }

    @PutMapping("{id}")
    public LeadResponseDto update(@PathVariable Long id, @RequestBody LeadRequestDto dto) {
        return leadService.update(id, dto);
    }

    @GetMapping
    public Page<LeadResponseDto> findAll() {
        return leadService.findAll();
    }

    @GetMapping("{id}")
    public LeadResponseDto findById(@PathVariable Long id) {
        return leadService.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        leadService.delete(id);
    }

}
