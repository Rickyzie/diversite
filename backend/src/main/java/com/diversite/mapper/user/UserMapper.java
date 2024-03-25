package com.diversite.mapper.user;

import com.diversite.entity.user.UserEntity;
import com.diversite.entity.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
     Boolean insertUser(UserEntity userEntity);
     UserInfo getUserById(Integer id);
     UserEntity findByEmailAndPassword(String email, String passwordHash);
     UserEntity findByEmail(String email);
     List<UserInfo> getAllUsers();
     void updateUser(UserInfo userInfo);
     void deleteUser(Integer id);
}



