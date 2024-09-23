package com.kaz.data_brazilian_company.controller;

import com.kaz.data_brazilian_company.model.Company;
import com.kaz.data_brazilian_company.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{cnpj}")
    public ResponseEntity<Company> getCompany(@PathVariable String cnpj) {
        log.info("### CompanyController.getCompany - Fetching company by cnpj: {}", cnpj);
        return ResponseEntity.ok(companyService.getCompanyByCnpj(cnpj));
    }
}
