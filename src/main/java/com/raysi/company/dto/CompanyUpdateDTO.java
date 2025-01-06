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
