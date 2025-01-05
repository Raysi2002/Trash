package com.raysi.company.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record CompanyDTO(
        String name,
        Integer noOfEmployee,
        LocalDate estDate,
        Long annualRevenue,
        String domain
        ){
}

//private Long regNo;
//private String name;
//private Integer noOfEmployee;
//@Column(name = "establishment_date")
//private LocalDate estDate;
//private Long annualRevenue;
//private Long netProfit;
//private String domain;