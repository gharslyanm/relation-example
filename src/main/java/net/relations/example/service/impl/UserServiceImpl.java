package net.relations.example.service.impl;

import net.relations.example.converter.DataConverter;
import net.relations.example.dto.UserDto;
import net.relations.example.repository.UserRepository;
import net.relations.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;
import java.util.List;

/**
 * Created by manukg on 10/28/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) throws SQLDataException {
        return DataConverter.fromUser(userRepository.save(DataConverter.fromUserDto(userDto)));
    }

    @Override
    public List<UserDto> findAll() throws SQLDataException {
        return DataConverter.fromUserList(userRepository.findAll());
    }

    @Override
    public UserDto findOne(Long userDtoId) throws SQLDataException {
        return DataConverter.fromUser(userRepository.findOne(userDtoId));
    }

    @Override
    public UserDto findByUserName(String userName) throws SQLDataException {
        return DataConverter.fromUser(userRepository.findByUserName(userName));
    }
}
