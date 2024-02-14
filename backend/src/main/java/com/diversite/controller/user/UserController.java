package com.diversite.controller.user;

import com.diversite.controller.user.pojo.UserLoginForm;
import com.diversite.controller.user.pojo.UserSignupForm;
import com.diversite.entity.user.UserEntity;
import com.diversite.response.ApiResponse;
import com.diversite.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
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
    public ResponseEntity<ApiResponse<Boolean>> loginUser(UserLoginForm userLoginForm) {
        try {
            String passwordHash = passwordEncoder.encode(userLoginForm.getPassword());
            UserEntity userEntity = userService.findByEmailAndPassword(userLoginForm.getEmail(), passwordHash);
            if(userEntity != null){
                return ResponseEntity.ok(new ApiResponse<Boolean>(true));
            }
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("duplicate key error"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("createUser error" ));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
        UserEntity userEntity = userService.getUserById(id);
        return ResponseEntity.ok(userEntity);
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
