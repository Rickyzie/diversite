package com.diversite.controller.user;

import com.diversite.service.user.UserAccount;
import com.diversite.service.user.UserAccountService;
import com.diversite.service.user.pojo.UserLoginForm;
import com.diversite.service.user.pojo.UserSignupForm;
import com.diversite.entity.user.UserEntity;
import com.diversite.response.ApiResponse;
import com.diversite.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserAccountService userAccountService;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserController(UserService userService,UserAccountService userAccountService,  BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Boolean>> createUser(UserSignupForm userSignupForm) {
        try {
            String passwordHash = passwordEncoder.encode(userSignupForm.getPassword());

            UserEntity userEntity = new UserEntity(
                    userSignupForm.getName(),
                    userSignupForm.getEmail(),
                    passwordHash
            );
            userEntity.setAddress(userSignupForm.getAddress());
            userEntity.setPhoneNumber(userSignupForm.getPhoneNumber());

            Boolean isAdded = userService.addUser(userEntity);
            if(isAdded){
                return ResponseEntity.ok(new ApiResponse<Boolean>(true));
            }
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("duplicate key error"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("createUser error" ));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Boolean>> loginUser(UserLoginForm userLoginForm, HttpSession session) {
        try {
            UserEntity userEntity = userService.findByEmail(userLoginForm.getEmail());
            boolean isMatch = passwordEncoder.matches(userLoginForm.getPassword(), userEntity.getPasswordHash());

            if(isMatch){
                UserDetails userDetails = userAccountService.loadUserByUsername(userEntity.getEmail());
                session.setAttribute("user", userDetails);
                return ResponseEntity.ok(new ApiResponse<Boolean>(true));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("loginUser error" ));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
        UserEntity userEntity = userService.getUserById(id);
        return ResponseEntity.ok(userEntity);
    }

    @GetMapping("/session")
    public ResponseEntity<ApiResponse<Boolean>> testSession(HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("user");
        if(userDetails != null){
            return ResponseEntity.ok(new ApiResponse<Boolean>(true));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }


    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody UserEntity userEntity) {
        userEntity.setId(id);
        userService.updateUser(userEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
