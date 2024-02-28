package com.diversite.service.admin;

import com.diversite.entity.admin.AdminEntity;
import com.diversite.entity.user.UserEntity;
import com.diversite.enumeration.AdminPrivilege;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class AdminAccountService implements  UserDetailsService {

    private AdminService adminService;


    public AdminAccountService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity adminEntity = adminService.findByAdminName(username);
        if(adminEntity == null) throw new UsernameNotFoundException("無此帳號");
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(AdminPrivilege.NORMAL_ADMIN_PRIVILEGE.getPrivilege())); // Example authority
        return new User(adminEntity.getAdminName(), adminEntity.getPasswordHash(), authorities);
    }
}

