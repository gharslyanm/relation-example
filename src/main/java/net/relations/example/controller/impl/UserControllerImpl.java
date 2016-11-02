package net.relations.example.controller.impl;

import net.relations.example.controller.UserController;
import net.relations.example.dto.UserDto;
import net.relations.example.service.UserService;
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
public class UserControllerImpl implements UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        try {
            if (userService.findByUserName(userDto.getUserName()) != null) {
                return new ResponseEntity<UserDto>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<UserDto>(userService.save(userDto), HttpStatus.CREATED);
        } catch (SQLDataException ex) {
            LOGGER.error("[UserControllerImpl][save] unable to save userDto object", ex.getMessage());
            return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        try {
            if (userService.findAll() != null && !userService.findAll().isEmpty()) {
                return new ResponseEntity<List<UserDto>>(userService.findAll(), HttpStatus.OK);
            }
            return new ResponseEntity<List<UserDto>>(HttpStatus.NOT_FOUND);
        } catch (SQLDataException ex) {
            LOGGER.error("[UserControllerImpl][findAll] unable to find list of userDto", ex.getMessage());
            return new ResponseEntity<List<UserDto>>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UserDto> findOne(@PathVariable(value = "userDtoId") Long userDtoId) {
        try {
            if (userService.findOne(userDtoId) != null) {
                return new ResponseEntity<UserDto>(userService.findOne(userDtoId), HttpStatus.OK);
            }
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        } catch (SQLDataException ex) {
            LOGGER.error("[UserControllerImpl][findOne] unable to find userDto object by userDtoId : [{}]", userDtoId, ex.getMessage());
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UserDto> findByUserName(@PathVariable(value = "userName") String userName) {
        try {
            if (userService.findByUserName(userName) != null) {
                return new ResponseEntity<UserDto>(userService.findByUserName(userName), HttpStatus.OK);
            }
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        } catch (SQLDataException ex) {
            LOGGER.error("[UserControllerImpl][findByUserName] unable to find userDto by userName : [{}]",userName,ex.getMessage());
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
    }
}
