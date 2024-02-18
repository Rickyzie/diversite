package com.diversite.service.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;

@Getter
@Setter
@ToString
public class UserAccount  implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String id;

    @Email(message = "帳號必須為電子信箱格式")
    @NotBlank(message = "帳號不可為空")
    private String account;

    @NotBlank(message = "密碼不可為空")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[0-9])[a-zA-Z]{1}[a-zA-Z0-9]{5,15}$",
            message = "密碼必須為6 至16 位英文及數字組成且首位字元為英文。")
    private String password;

    private String salt;

    @Override
    // 取得所有權限
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    // 取得使用者名稱
    public String getUsername() {
        // TODO Auto-generated method stub
        return account;
    }

    @Override
    // 取得密碼
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    // 帳號是否過期
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    // 帳號是否被鎖定
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    // 憑證/密碼是否過期
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    // 帳號是否可用
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
