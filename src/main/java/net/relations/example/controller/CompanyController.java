package net.relations.example.controller;

import net.relations.example.dto.CompanyDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by manukg on 11/1/2016.
 */
@RestController
@RequestMapping("/company")
public interface CompanyController {
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompanyDto> save(@RequestBody CompanyDto companyDto);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CompanyDto>> findAll();

    @RequestMapping(value = "/{companyDtoId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompanyDto> findOne(@PathVariable(value = "companyDtoId") Long companyDtoId);

    @RequestMapping(value = "/company-name/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompanyDto> findByCompanyName(@PathVariable(value = "companyName") String companyName);


}
