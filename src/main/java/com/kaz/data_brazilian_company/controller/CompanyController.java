package com.kaz.data_brazilian_company.controller;

import com.kaz.data_brazilian_company.dto.CnpjDto;
import com.kaz.data_brazilian_company.model.Company;
import com.kaz.data_brazilian_company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Company Management")
@RestController
@RequestMapping("/v1/company")
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @Operation(summary = "Retrieve a company by CNPJ", description = "Fetch a company by providing the CNPJ. If it is not found in the system, a new company will be created.")
    @GetMapping("/{cnpj}")
    public ResponseEntity<Company> getCompanyByCnpj(@PathVariable String cnpj) {
        log.info("### CompanyController.getCompany - Fetching company by cnpj: {}", cnpj);
        return ResponseEntity.ok(companyService.getCompanyByCnpj(cnpj));
    }

    @Operation(summary = "Retrieve all companies", description = "Fetch a list of all companies registered in the system.")
    @GetMapping
    public ResponseEntity<Iterable<Company>> getAllCompanies() {
        log.info("### CompanyController.getAllCompanies - Fetching all companies");
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @Operation(summary = "Create a new company", description = "Create a new company by providing only the CNPJ.")
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody CnpjDto cnpj) {
        log.info("### CompanyController.saveCompany - Saving company: {}", cnpj.getCnpj());
        return ResponseEntity.ok(companyService.saveCompany(cnpj.getCnpj()));
    }

    @Operation(summary = "Delete a company by CNPJ", description = "Delete a company from the system by providing the CNPJ.")
    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Void> deleteCompanyByCnpj(@PathVariable String cnpj) {
        log.info("### CompanyController.deleteCompanyByCnpj - Deleting company by cnpj: {}", cnpj);
        companyService.deleteCompanyByCnpj(cnpj);
        return ResponseEntity.ok().build();
    }
}
