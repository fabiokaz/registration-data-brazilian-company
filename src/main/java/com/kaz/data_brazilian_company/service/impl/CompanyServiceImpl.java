package com.kaz.data_brazilian_company.service.impl;


import com.kaz.data_brazilian_company.model.Company;
import com.kaz.data_brazilian_company.repository.CompanyRepository;
import com.kaz.data_brazilian_company.service.CompanyQueryService;
import com.kaz.data_brazilian_company.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if(findCompanyByCnpj(cnpj) == null){
            log.info("### Company is not present in database, fetching from external API by cnpj and inserting: {}", cnpj);
            return insertCompany(cnpj);
        }

        return companyRepository.findByCnpj(formatCnpj(cnpj)).orElseGet(() ->
                {

                    return insertCompany(cnpj);
                }
        );
    }

    private String formatCnpj(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");
        if (cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ must have 14 digits.");
        }
        return cnpj.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }

    @Override
    public Company saveCompany(String cnpj) {
        return getCompanyByCnpj(cnpj);
    }

    @Override
    public Iterable<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCompanyByCnpj(String cnpj) {
        companyRepository.deleteByCnpj(formatCnpj(cnpj));
    }

    private Company insertCompany(String cnpj) {
        Company company = companyQueryService.getCompanyByCnpj(cnpj);
        if(company == null) {
            log.error("### Company not found by cnpj : {}", cnpj);
            throw new RuntimeException("Company not found by cnpj : " + cnpj);
        }
        log.info("### Company found by cnpj : {}", cnpj);
        companyRepository.save(company);
        return company;
    }

    private Company findCompanyByCnpj(String cnpj) {
        return companyRepository.findByCnpj(formatCnpj(cnpj)).orElse(null);
    }
}
