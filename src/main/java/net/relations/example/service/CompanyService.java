package net.relations.example.service;

import net.relations.example.dto.CompanyDto;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

/**
 * Created by manukg on 10/28/2016.
 */


public interface CompanyService {
    /**
     * method saves companyDto object
     *
     * @param companyDto
     * @return
     * @throws SQLDataException
     */
    CompanyDto save(CompanyDto companyDto) throws SQLDataException;

    /**
     * method returns list of all companyDto objects
     *
     * @return
     * @throws SQLDataException
     */
    List<CompanyDto> findAll() throws SQLDataException;

    /**
     * method returns companyDto object by companyDtoId
     *
     * @param companyDtoId
     * @return
     * @throws SQLDataException
     */
    CompanyDto findOne(Long companyDtoId) throws SQLDataException;

    /**
     * method returns companyDto object by companyName
     *
     * @param companyName
     * @return
     * @throws SQLDataException
     */
    CompanyDto findByCompanyName(String companyName) throws SQLDataException;
}
