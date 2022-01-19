package com.naman.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VendorDTO {

    @JsonIgnore
    public static final String BASE_URL = "/api/v1/vendors";

    String name;

    @JsonProperty("vendor_url")
    String vendorUrl;
}
