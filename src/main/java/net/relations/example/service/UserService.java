package net.relations.example.service;

import net.relations.example.dto.UserDto;

import java.sql.SQLDataException;
import java.util.List;

/**
 * Created by manukg on 10/28/2016.
 */
public interface UserService {
    /**
     * method saves userDto object
     *
     * @param userDto
     * @return
     * @throws SQLDataException
     */
    UserDto save(UserDto userDto) throws SQLDataException;

    /**
     * method returns list of all userDto objects
     *
     * @return
     * @throws SQLDataException
     */
    List<UserDto> findAll() throws SQLDataException;

    /**
     * method returns userDto object by userDtoId
     *
     * @param userDtoId
     * @return
     * @throws SQLDataException
     */
    UserDto findOne(Long userDtoId) throws SQLDataException;

    /**
     * method returns userDto object by userName
     *
     * @param userName
     * @return
     * @throws SQLDataException
     */
    UserDto findByUserName(String userName) throws SQLDataException;
}
