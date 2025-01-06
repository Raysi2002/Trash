package com.raysi.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyUpdateDTO {
    private String name;
    private Integer noOfEmployee;
    private Long annualRevenue;
    private Long netProfit;
}

//private Long regNo;
//private String name;
//private Integer noOfEmployee;
//@Column(name = "establishment_date")
//private LocalDate estDate;
//private Long annualRevenue;
//private Long netProfit;
//private String domain;