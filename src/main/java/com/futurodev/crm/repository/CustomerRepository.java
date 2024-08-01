package com.futurodev.crm.repository;

import com.futurodev.crm.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Lead, Long> {
}
