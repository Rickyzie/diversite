package com.diversite.service.user;

import java.util.Collections;
import java.util.List;

import com.diversite.entity.user.UserEntity;
import com.diversite.enumeration.AdminPrivilege;
import com.diversite.enumeration.UserPrivilege;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserAccountService implements  UserDetailsService {

    private UserService userService;


    public UserAccountService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByEmail(username);
        if(userEntity == null) throw new UsernameNotFoundException("無此帳號");
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(UserPrivilege.NORMAL_USER_PRIVILEGE.getPrivilege())); // Example authority
        return new User(userEntity.getEmail(), userEntity.getPasswordHash(), authorities);
    }
}

