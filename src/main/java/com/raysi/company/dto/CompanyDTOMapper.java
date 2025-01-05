package com.raysi.company.dto;

import com.raysi.company.entity.Company;

import java.time.LocalDate;
import java.util.function.Function;

public class CompanyDTOMapper implements Function<Company, CompanyDTO> {
    @Override
    public CompanyDTO apply(Company company) {
        return new CompanyDTO(
                company.getName(),
                company.getNoOfEmployee(),
                company.getEstDate(),
                company.getAnnualRevenue(),
                company.getDomain()
        );
    }
}
//String name,
//Integer noOfEmployee,
//LocalDate estDate,
//Long annualRevenue,
//String domain