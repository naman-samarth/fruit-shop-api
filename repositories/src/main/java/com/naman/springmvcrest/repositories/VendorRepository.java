package com.naman.springmvcrest.repositories;

import com.naman.springmvcrest.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
