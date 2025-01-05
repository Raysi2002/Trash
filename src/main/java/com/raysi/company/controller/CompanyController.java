package com.raysi.company.controller;

import com.raysi.company.dto.CompanyDTO;
import com.raysi.company.error.ResourceNotFoundException;
import com.raysi.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("/company")
    public ResponseEntity<List<CompanyDTO>> fetchCompany(){
        try{
            List<CompanyDTO> companyDTOS = companyService.fetchCompany();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Accept-Datetime")
                    .body(companyDTOS);
        }catch(ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new ResourceNotFoundException("703", "Something went wrong in Controller Layer");
        }
    }
}
