package com.kaz.data_brazilian_company.service;

import com.kaz.data_brazilian_company.model.Company;

public interface CompanyService {
    public Company getCompanyByCnpj(String cnpj);
}
