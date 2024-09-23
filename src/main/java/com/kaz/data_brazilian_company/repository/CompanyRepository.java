package com.kaz.data_brazilian_company.repository;


import com.kaz.data_brazilian_company.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findByCnpj(String cnpj);

    void deleteByCnpj(String cnpj);

}
