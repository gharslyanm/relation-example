package net.relations.example.service;

import net.relations.example.dto.CompanyDto;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

/**
 * Created by manukg on 10/28/2016.
 */


public interface CompanyService {
    CompanyDto save(CompanyDto companyDto) throws SQLDataException;

    List<CompanyDto> findAll() throws SQLDataException;

    CompanyDto findOne(Long companyDtoId) throws SQLDataException;

    CompanyDto findByCompanyName(String companyName) throws SQLDataException;
}
