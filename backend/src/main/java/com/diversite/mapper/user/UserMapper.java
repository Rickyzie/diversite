package com.diversite.mapper.user;

import com.diversite.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
     Boolean insertUser(UserEntity userEntity);
     UserEntity getUserById(Integer id);
     UserEntity findByEmailAndPassword(String email, String passwordHash);
     UserEntity findByEmail(String email);
     List<UserEntity> getAllUsers();
     void updateUser(UserEntity userEntity);
     void deleteUser(Integer id);
}



