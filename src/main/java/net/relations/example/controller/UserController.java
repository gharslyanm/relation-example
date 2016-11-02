package net.relations.example.controller;

import net.relations.example.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by manukg on 11/1/2016.
 */
@RestController
@RequestMapping("/user")
public interface UserController {
    /**
     * endPoint invokes userService for saving userDto object
     *
     * @param userDto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> save(@RequestBody UserDto userDto);

    /**
     * endPoint invokes userService for getting list of all userDto objects
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserDto>> findAll();

    /**
     * endPoint invokes userService for getting userDto by userDtoId
     *
     * @param userDtoId
     * @return
     */
    @RequestMapping(value = "/{userDtoId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> findOne(@PathVariable(value = "userDtoId") Long userDtoId);

    /**
     * endPoint invokes userService for getting userDto by userName
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/user-name/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> findByUserName(@PathVariable(value = "userName") String userName);
}
