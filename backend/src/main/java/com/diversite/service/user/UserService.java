package com.diversite.service.user;

import com.diversite.entity.user.UserEntity;
import com.diversite.entity.user.UserInfo;
import com.diversite.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService  {
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
    public UserInfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Transactional(readOnly = true)
    public UserEntity findByEmailAndPassword(String email, String passwordHash) {
        return userMapper.findByEmailAndPassword(email, passwordHash);
    }

    @Transactional(readOnly = true)
    public UserEntity findByEmail(String email ) {
        return userMapper.findByEmail(email);
    }


    @Transactional(readOnly = true)
    public List<UserInfo> getAllUsers() {
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