package com.kaz.data_brazilian_company.service;


import com.kaz.data_brazilian_company.model.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "receitaws", url = "https://receitaws.com.br/v1/cnpj/")
public interface CompanyQueryService {

    @GetMapping(value = "/{cnpj}")
    Company getCompanyByCnpj(@PathVariable("cnpj") String cnpj);
}
