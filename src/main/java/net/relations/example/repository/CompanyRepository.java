package net.relations.example.repository;

import net.relations.example.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manukg on 10/28/2016.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyName(String companyName);
}
