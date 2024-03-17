package com.diversite.mapper.admin;

import com.diversite.entity.admin.AdminEntity;
import com.diversite.entity.admin.AdminInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
     Boolean addAdmin(AdminEntity adminEntity);
     AdminEntity getAdminById(Integer id);
     AdminEntity findByAdminNameAndPasswordHash(String adminName, String passwordHash);
     AdminEntity findByAdminName(String AdminName);
     List<AdminInfo> getAllAdmins();
     void updateAdmin(AdminEntity adminEntity);
     void deleteAdmin(Integer id);
}



