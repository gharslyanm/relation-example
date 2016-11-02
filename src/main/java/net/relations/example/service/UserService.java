package net.relations.example.service;

import net.relations.example.dto.UserDto;

import java.sql.SQLDataException;
import java.util.List;

/**
 * Created by manukg on 10/28/2016.
 */
public interface UserService {
    UserDto save(UserDto userDto) throws SQLDataException;

    List<UserDto> findAll() throws SQLDataException;

    UserDto findOne(Long userDtoId) throws SQLDataException;

    UserDto findByUserName(String userName) throws SQLDataException;
}
