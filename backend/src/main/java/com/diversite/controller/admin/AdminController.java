package com.diversite.controller.admin;

import com.diversite.controller.admin.pojo.AdminInfo;
import com.diversite.entity.admin.AdminEntity;
import com.diversite.response.ApiResponse;
import com.diversite.service.admin.AdminAccountService;
import com.diversite.service.admin.AdminService;
import com.diversite.service.admin.pojo.AdminAddForm;
import com.diversite.service.admin.pojo.AdminLoginForm;
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>("error" ));
    }



    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Boolean>> logoutAdmin(HttpSession session) {
        try {
            // Invalidate the current session and remove any associated data
            session.invalidate();
            // Return a successful response indicating the user has been logged out
            return ResponseEntity.ok(new ApiResponse<>(true));
        } catch (Exception e) {
            // In case of any exceptions, return a server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>("Logout error"));
        }
    }

    @GetMapping("/info")
    public ResponseEntity<ApiResponse<AdminInfo>> getAdminInfoBySession(HttpSession session) {
        UserDetails userDetails = (UserDetails)session.getAttribute("admin");
        AdminInfo adminInfo = new AdminInfo(userDetails.getUsername());
        return ResponseEntity.ok(new ApiResponse<AdminInfo>(adminInfo));
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


    @GetMapping("/session")
    public ResponseEntity<ApiResponse<Boolean>> testSession(HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("admin");
        if(userDetails != null){
            return ResponseEntity.ok(new ApiResponse<Boolean>(true));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
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
