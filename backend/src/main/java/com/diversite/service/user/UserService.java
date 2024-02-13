package com.diversite.service.user;

import com.diversite.entity.user.UserEntity;
import com.diversite.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public Boolean addUser(UserEntity userEntity) {
        return userMapper.insertUser(userEntity);
    }

    @Transactional(readOnly = true)
    public UserEntity getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Transactional
    public void updateUser(UserEntity userEntity) {
        userMapper.updateUser(userEntity);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}