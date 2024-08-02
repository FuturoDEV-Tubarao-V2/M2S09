package com.futurodev.crm.repository;

import com.futurodev.crm.enumerated.LeadStatus;
import com.futurodev.crm.model.Lead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    /*****************/
    /** DerivedQuery */
    /*****************/
    // SELECT * FROM leads WHERE status = "" AND UPPER(city) = UPPER("")
    Page<Lead> findByStatusAndCityIgnoreCase(LeadStatus status, String city, Pageable pageable);

    /*********/
    /** JPQL */
    /*********/
    // SELECT l.* FROM leads l
    // JOIN customer c ON c.id = l.customer_id
    // WHERE l.status = :status AND c.city = :city
    @Query("SELECT l FROM Lead l WHERE l.status = :status AND l.customer.city = :city ")
    List<Lead> findByStatusAndCity(LeadStatus status, String city);

    /***************/
    /** SQL Native */
    /***************/
    // SELECT l.* FROM leads l
    // JOIN customer c ON c.id = l.customer_id
    // WHERE l.status = :status AND c.city = :city
    @Query(
            value = "SELECT l.* FROM leads l WHERE l.status = :status",
            nativeQuery = true
    )
    List<Lead> findNativeByStatusAndCity(String status);

}
