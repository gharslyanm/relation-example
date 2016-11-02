package net.relations.example.service.impl;

import net.relations.example.converter.DataConverter;
import net.relations.example.dto.CompanyDto;
import net.relations.example.entity.Company;
import net.relations.example.repository.CompanyRepository;
import net.relations.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;
import java.util.List;

/**
 * Created by manukg on 10/28/2016.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto save(CompanyDto companyDto) throws SQLDataException {
        return DataConverter.fromCompany(companyRepository.save(DataConverter.fromCompanyDto(companyDto)));
    }

    @Override
    public List<CompanyDto> findAll() throws SQLDataException {
        return DataConverter.fromCompanyList(companyRepository.findAll());
    }

    @Override
    public CompanyDto findOne(Long companyDtoId) throws SQLDataException {
        return DataConverter.fromCompanyAfterSaving(companyRepository.findOne(companyDtoId));
    }

    @Override
    public CompanyDto findByCompanyName(String companyName) throws SQLDataException {
        return DataConverter.fromCompanyAfterSaving(companyRepository.findByCompanyName(companyName));
    }


}
