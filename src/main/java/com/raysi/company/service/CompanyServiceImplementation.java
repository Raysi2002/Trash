package com.raysi.company.service;

import com.raysi.company.dto.CompanyDTO;
import com.raysi.company.dto.CompanyUpdateDTO;
import com.raysi.company.entity.Company;
import com.raysi.company.error.ResourceNotFoundException;
import com.raysi.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService{

    private final CompanyRepository companyRepository;

    public CompanyServiceImplementation(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }


    @Override
    public List<CompanyDTO> fetchCompany() {
        List<CompanyDTO> companyDTOS = companyRepository.findAll()
                .stream()
                .map(company -> new CompanyDTO(
                        company.getName(),
                        company.getNoOfEmployee(),
                        company.getEstDate(),
                        company.getAnnualRevenue(),
                        company.getDomain()
                )).toList();
        if(companyDTOS.isEmpty())
            throw new ResourceNotFoundException("701", "Resources not found!");
        try{
            return companyDTOS;
        }catch(ResourceNotFoundException e){
            throw new ResourceNotFoundException("702", "Something went wrong in Service layer");
        }
    }

    @Override
    public Optional<CompanyDTO> fetchCompanyById(Long id) {
        Optional<CompanyDTO> company = companyRepository.findById(id)
                .map(company1 -> new CompanyDTO(
                        company1.getName(),
                        company1.getNoOfEmployee(),
                        company1.getEstDate(),
                        company1.getAnnualRevenue(),
                        company1.getDomain()
                ));
        if(company.isEmpty())
            throw new ResourceNotFoundException("801", "No companies with such reg no. found !");
        try{
            return company;
        }catch(Exception e){
            throw new ResourceNotFoundException("802", "Something went wrong in Service layer");
        }
    }

    @Override
    public void saveCompany(Company company) {

    }

    @Override
    public void saveListOfCompany(List<Company> companies) {

    }

    @Override
    public void deleteCompany(Long id) {

    }

    @Override
    public void updateCompany(Long id, CompanyUpdateDTO companyUpdateDTO) {

    }
}
