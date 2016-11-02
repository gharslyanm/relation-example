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
    /**
     * endPoint invokes companyService for saving companyDto object
     *
     * @param companyDto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompanyDto> save(@RequestBody CompanyDto companyDto);

    /**
     * endPoint invokes companyService for getting list of all companyDto objects
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CompanyDto>> findAll();

    /**
     * endPoint invokes companyService for getting companyDto by companyId
     *
     * @param companyDtoId
     * @return
     */
    @RequestMapping(value = "/{companyDtoId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompanyDto> findOne(@PathVariable(value = "companyDtoId") Long companyDtoId);

    /**
     * endPoint invokes companyService for getting companyDto by companyName
     *
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/company-name/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompanyDto> findByCompanyName(@PathVariable(value = "companyName") String companyName);


}
