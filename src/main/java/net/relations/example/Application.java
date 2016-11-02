package net.relations.example;

import net.relations.example.dto.CompanyDto;
import net.relations.example.dto.UserDto;
import net.relations.example.entity.Company;
import net.relations.example.entity.User;
import net.relations.example.repository.CompanyRepository;
import net.relations.example.service.CompanyService;
import net.relations.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manukg on 10/28/2016.
 */
@SpringBootApplication
public class Application implements CommandLineRunner
         {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyName("WW");

        CompanyDto companyDto2 = new CompanyDto();
        companyDto2.setCompanyName("PP");

        Set<UserDto> users = new HashSet<>();
        Set<UserDto> users2=new HashSet<>();

        UserDto userDto1 = new UserDto();
        UserDto userDto2 = new UserDto();
        UserDto userDto3 = new UserDto();

        UserDto userDto4=new UserDto();

        userDto1.setUserName("GG");
        userDto1.setCompany(companyDto);
        users.add(userDto1);

        userDto2.setUserName("KK");
        userDto2.setCompany(companyDto);
        users.add(userDto2);

        userDto3.setUserName("RR");
        userDto3.setCompany(companyDto);
        users.add(userDto3);

        userDto4.setUserName("VV");
        userDto4.setCompany(companyDto2);
        users2.add(userDto4);

        companyDto.setUsers(users);
        companyService.save(companyDto);

        companyDto2.setUsers(users2);
        companyService.save(companyDto2);

    }

}
