package com.diversite.service.user;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.diversite.entity.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;


@Service
public class UserAccountService implements  UserDetailsService {

    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder;

    public UserAccountService(UserService userService) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByEmail(username);
        if(userEntity == null) throw new UsernameNotFoundException("無此帳號");
        UserAccount userAccount = new UserAccount();
        userAccount.setId(String.valueOf(userEntity.getId()));
        userAccount.setAccount(userEntity.getEmail());
        userAccount.setPassword(userEntity.getPasswordHash());
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")); // Example authority
        return new User(userEntity.getEmail(), userEntity.getPasswordHash(), authorities);
    }
}

