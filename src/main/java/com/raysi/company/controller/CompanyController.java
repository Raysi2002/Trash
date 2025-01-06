package com.raysi.company.controller;

import com.raysi.company.dto.CompanyDTO;
import com.raysi.company.dto.CompanyUpdateDTO;
import com.raysi.company.entity.Company;
import com.raysi.company.error.ResourceNotFoundException;
import com.raysi.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/company/{id}")
    public ResponseEntity<Optional<CompanyDTO>> fetchById(@PathVariable Long id){
        Optional<CompanyDTO> companyDTO = companyService.fetchCompanyById(id);
        try{
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .header("Accept-Datetime")
                    .body(companyDTO);
        }catch (ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new RuntimeException("Something went wrong in Controller layer!");
        }
    }

    @PatchMapping("/company/{id}")
    public ResponseEntity<CompanyUpdateDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyUpdateDTO companyUpdateDTO){
        try{
            companyService.updateCompany(id, companyUpdateDTO);
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .header("Accept-Datetime")
                    .body(companyUpdateDTO);
        } catch (RuntimeException e) {
            throw e;
        }catch (Exception e){
            throw new RuntimeException("Something went wrong in controller layer");
        }
    }
}
