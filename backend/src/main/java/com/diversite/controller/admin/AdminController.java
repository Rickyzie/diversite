package com.diversite.controller.admin;

import com.diversite.entity.admin.AdminEntity;
import com.diversite.entity.user.UserEntity;
import com.diversite.response.ApiResponse;
import com.diversite.service.admin.AdminAccountService;
import com.diversite.service.admin.AdminService;
import com.diversite.service.admin.pojo.AdminAddForm;
import com.diversite.service.admin.pojo.AdminLoginForm;
import com.diversite.service.user.pojo.UserSignupForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;
    private final AdminAccountService adminAccountService;
    private final BCryptPasswordEncoder passwordEncoder;


    public AdminController(AdminService adminService, AdminAccountService adminAccountService, BCryptPasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.adminAccountService = adminAccountService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Boolean>> loginAdmin(AdminLoginForm adminLoginForm, HttpSession session) {
        try {
            AdminEntity adminEntity = adminService.findByAdminName(adminLoginForm.getAdminName());
            boolean isMatch = passwordEncoder.matches(adminLoginForm.getPassword(), adminEntity.getPasswordHash());

            if(isMatch){
                UserDetails userDetails = adminAccountService.loadUserByUsername(adminEntity.getAdminName());
                session.setAttribute("admin", userDetails);
                return ResponseEntity.ok(new ApiResponse<Boolean>(true));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("loginAdmin error" ));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Boolean>> createAdmin(AdminAddForm adminAddForm) {
        try {
            String passwordHash = passwordEncoder.encode(adminAddForm.getPassword());

            AdminEntity adminEntity = new AdminEntity(
                    adminAddForm.getAdminName(),
                    passwordHash
            );

            Boolean isAdded = adminService.addAdmin(adminEntity);
            if(isAdded){
                return ResponseEntity.ok(new ApiResponse<Boolean>(true));
            }
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("duplicate key error"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("addAdmin error" ));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminEntity> getAdminById(@PathVariable Integer id) {
        AdminEntity adminEntity = adminService.getAdminById(id);
        return ResponseEntity.ok(adminEntity);
    }

    @GetMapping("/session")
    public ResponseEntity<ApiResponse<Boolean>> testSession(HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("admin");
        if(userDetails != null){
            return ResponseEntity.ok(new ApiResponse<Boolean>(true));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }


    @GetMapping
    public ResponseEntity<List<AdminEntity>> getAllAdmins() {
        List<AdminEntity> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAdmin(@PathVariable Integer id, @RequestBody AdminEntity adminEntity) {
        adminEntity.setId(id);
        adminService.updateAdmin(adminEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }
}
