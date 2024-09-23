package com.kaz.data_brazilian_company.service.impl;


import com.kaz.data_brazilian_company.model.Company;
import com.kaz.data_brazilian_company.repository.CompanyRepository;
import com.kaz.data_brazilian_company.service.CompanyQueryService;
import com.kaz.data_brazilian_company.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    private CompanyQueryService companyQueryService;

    @Override
    public Company getCompanyByCnpj(String cnpj) {
        log.info("### Fetching company by cnpj: {}", cnpj);
        return companyRepository.findByCnpj(cnpj).orElseGet(() ->
                {
                    log.info("### Company is not present in database, fetching from external API by cnpj: {}", cnpj);
                    Company company = companyQueryService.getCompanyByCnpj(cnpj);
                    if(company == null) {
                        log.error("### Company not found by cnpj : {}", cnpj);
                        throw new RuntimeException("Company not found by cnpj : " + cnpj);
                    }
                    log.info("### Company found by cnpj : {}", cnpj);
                    companyRepository.save(company);
                    return company;
                }
        );
    }

}
