package com.raysi.company.service;

import com.raysi.company.dto.CompanyDTO;
import com.raysi.company.dto.CompanyUpdateDTO;
import com.raysi.company.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    List<CompanyDTO> fetchCompany();
    Optional<CompanyDTO> fetchCompanyById(Long id);
    void saveCompany(Company company);
    void saveListOfCompany(List<Company> companies);
    void deleteCompany(Long id);
    void updateCompany(Long id, CompanyUpdateDTO companyUpdateDTO);
}
