package com.naman.springmvcrest.mapper;

import com.naman.springmvcrest.domain.Vendor;
import com.naman.springmvcrest.model.VendorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    @Mapping(target = "id", ignore = true)
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);

    @Mapping(target = "vendorUrl", ignore = true)
    VendorDTO vendorToVendorDTO(Vendor vendor);
}
