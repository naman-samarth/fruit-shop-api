package com.naman.springmvcrest.mapper;

import com.naman.springmvcrest.domain.Vendor;
import com.naman.springmvcrest.model.VendorDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendorMapperTest {

    VendorMapper mapper = VendorMapper.INSTANCE;

    public static final String NAME = "John";

    @Test
    void vendorDTOToVendor() {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        Vendor vendor = mapper.vendorDTOToVendor(vendorDTO);
        assertEquals(NAME, vendor.getName());
    }

    @Test
    void vendorToVendorDTO() {
        Vendor vendor = new Vendor();
        vendor.setName(NAME);

        VendorDTO vendorDTO = mapper.vendorToVendorDTO(vendor);
        assertEquals(NAME, vendorDTO.getName());
    }
}