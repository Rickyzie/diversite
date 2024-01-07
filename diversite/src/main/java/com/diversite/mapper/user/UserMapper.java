package com.diversite.mapper.user;

import com.diversite.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
     void insertUser(UserEntity userEntity);
     UserEntity getUserById(Integer id);
     List<UserEntity> getAllUsers();
     void updateUser(UserEntity userEntity);
     void deleteUser(Integer id);
}



