package com.diversite.service.admin;

import com.diversite.entity.admin.AdminEntity;

import com.diversite.mapper.admin.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService  {
    private final AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Transactional
    public Boolean addAdmin(AdminEntity adminEntity) {
        return adminMapper.addAdmin(adminEntity);
    }

    @Transactional(readOnly = true)
    public AdminEntity getAdminById(Integer id) {
        return adminMapper.getAdminById(id);
    }

    @Transactional(readOnly = true)
    public AdminEntity findByAdminNameAndPasswordHash(String adminName, String passwordHash) {
        return adminMapper.findByAdminNameAndPasswordHash(adminName, passwordHash);
    }

    @Transactional(readOnly = true)
    public AdminEntity findByAdminName(String adminName ) {
        return adminMapper.findByAdminName(adminName);
    }


    @Transactional(readOnly = true)
    public List<AdminEntity> getAllAdmins() {
        return adminMapper.getAllAdmins();
    }

    @Transactional
    public void updateAdmin(AdminEntity adminEntity) {
        adminMapper.updateAdmin(adminEntity);
    }

    @Transactional
    public void deleteAdmin(Integer id) {
        adminMapper.deleteAdmin(id);
    }
}