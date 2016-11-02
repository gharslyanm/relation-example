package net.relations.example.controller.impl;

import net.relations.example.controller.CompanyController;
import net.relations.example.dto.CompanyDto;
import net.relations.example.repository.CompanyRepository;
import net.relations.example.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLDataException;
import java.util.List;

/**
 * Created by manukg on 11/1/2016.
 */
@Component
public class CompanyControllerImpl implements CompanyController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;


    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ResponseEntity<CompanyDto> save(@RequestBody CompanyDto companyDto) {
        try {
            if (companyService.findByCompanyName(companyDto.getCompanyName()) != null) {
                return new ResponseEntity<CompanyDto>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<CompanyDto>(companyService.save(companyDto), HttpStatus.CREATED);
        } catch (SQLDataException ex) {
            LOGGER.error("[CompanyControllerImpl][save] unable to save componentDto object", ex.getMessage());
            return new ResponseEntity<CompanyDto>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<CompanyDto>> findAll() {
        try {
            if (companyService.findAll() != null && !companyService.findAll().isEmpty()) {
                return new ResponseEntity<List<CompanyDto>>(companyService.findAll(), HttpStatus.OK);
            }
            return new ResponseEntity<List<CompanyDto>>(HttpStatus.NOT_FOUND);
        } catch (SQLDataException ex) {
            LOGGER.error("[CompanyControllerImpl][findAll] unable to find all companyDtos", ex.getMessage());
            return new ResponseEntity<List<CompanyDto>>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<CompanyDto> findOne(@PathVariable(value = "companyDtoId") Long companyDtoId) {
        try {
            if (companyService.findOne(companyDtoId) != null) {
                return new ResponseEntity<CompanyDto>(companyService.findOne(companyDtoId), HttpStatus.OK);
            }
            return new ResponseEntity<CompanyDto>(HttpStatus.NOT_FOUND);
        } catch (SQLDataException ex) {
            LOGGER.error("[CompanyControllerImpl][findOne] unable to find companyDto object by companyId : [{}]", companyDtoId, ex.getMessage());
            return new ResponseEntity<CompanyDto>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<CompanyDto> findByCompanyName(@PathVariable(value = "companyName") String companyName) {
        try {
            if (companyService.findByCompanyName(companyName) != null) {
                return new ResponseEntity<CompanyDto>(companyService.findByCompanyName(companyName), HttpStatus.OK);
            }
            return new ResponseEntity<CompanyDto>(HttpStatus.NOT_FOUND);
        } catch (SQLDataException ex) {
            LOGGER.error("[CompanyControllerImpl][findByCompanyName] unable to find companyDto by companyName : [{}]", companyName, ex.getMessage());
            return new ResponseEntity<CompanyDto>(HttpStatus.NOT_FOUND);
        }

    }

}
