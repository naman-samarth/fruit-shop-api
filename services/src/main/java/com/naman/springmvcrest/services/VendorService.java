package com.naman.springmvcrest.services;

import com.naman.springmvcrest.model.VendorDTO;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO createVendor(VendorDTO vendorDTO);

    void deleteVendor(Long id);

    VendorDTO findVendor(Long id);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);

}
