package net.relations.example.converter;

import net.relations.example.dto.CompanyDto;
import net.relations.example.dto.UserDto;
import net.relations.example.entity.Company;
import net.relations.example.entity.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by manukg on 10/28/2016.
 */

public class DataConverter {

    private static final Mapper mapper = new DozerBeanMapper();

    public static UserDto fromUser(User user) {
        if (user != null) {
            user.getCompany().setUsers(null);
            return mapper.map(user, UserDto.class);
        }
        return null;
    }

    public static User fromUserDto(UserDto userDto) {
        return (userDto != null) ? mapper.map(userDto, User.class) : null;
    }

    public static CompanyDto fromCompany(Company company) {
        return (company!=null)?mapper.map(company,CompanyDto.class):null;
    }
    public static CompanyDto fromCompanyAfterSaving(Company company) {
        if (company != null) {
            Set<User> users = (company.getUsers() != null && !company.getUsers().isEmpty()) ? company.getUsers().stream().map(user -> {
                user.setCompany(null);
                return user;
            }).collect(Collectors.toSet()) : null;
            return mapper.map(company, CompanyDto.class);
        }
        return null;
    }

    public static Company fromCompanyDto(CompanyDto companyDto) {
        return (companyDto != null) ? mapper.map(companyDto, Company.class) : null;
    }

    public static List<UserDto> fromUserList(List<User> users) {
        return (users != null && !users.isEmpty()) ? users.stream().map(user -> {
            user.getCompany().setUsers(null);
            return mapper.map(user, UserDto.class);
        }).collect(Collectors.toList()) : null;
    }


    public static List<CompanyDto> fromCompanyList(List<Company> companies) {
        return (companies != null && !companies.isEmpty()) ? companies.stream().map(company -> {
            company.getUsers().stream().map(user -> {
                user.setCompany(null);
                return user;
            }).collect(Collectors.toSet());
            return mapper.map(company, CompanyDto.class);
        }).collect(Collectors.toList()) : null;
    }

//    public static Set<UserDto> fromUserSet(List<User> users) {
//        return (users != null && !users.isEmpty()) ? users.stream().map(user -> {
//            user.setCompany(null);
//            return mapper.map(user, UserDto.class);
//        }).collect(Collectors.toSet()) : null;
//    }
//
//
//    public static Set<CompanyDto> fromCompanySet(List<Company> companies) {
//        return (companies != null && !companies.isEmpty()) ? companies.stream().map(company -> {
//            company.getUsers().stream().map(user -> {
//                user.setCompany(null);
//                return user;
//            }).collect(Collectors.toList());
//            return mapper.map(company, CompanyDto.class);
//        }).collect(Collectors.toSet()) : null;
//    }


}
