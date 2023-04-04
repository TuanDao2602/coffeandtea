package ra.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Roles;
import ra.model.entity.Users;
import ra.model.service.UserService;
import ra.payload.request.StatusRequest;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @PutMapping("/userStatus/{userId}")
    @PreAuthorize(" hasRole('ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable("userId")int userId , @RequestBody StatusRequest statusRequest){
        Users users = userService.findUserById(userId);
        boolean check = false;
        for (Roles roles:users.getListRoles()) {
            if (roles.getRoleName().equals("ROLE_ADMIN")){
                check=true;
                break;
            }
        }
        if (check){
            return ResponseEntity.ok("không thể cập nhật tài khoản này");
        }else {
            users.setUserStatus(statusRequest.isUserStatus());
            return ResponseEntity.ok(userService.saveOrUpdate(users));
        }
    }


    @GetMapping("/alluser")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Users>findAllUser(){
        return userService.findAllUsers();
    }


//    @Autowired
//    private CartService userService;
//    @PutMapping("/userStatus/{userId}")
//    public ResponseEntity<?> getUserById(@PathVariable("userId")int userId , @RequestBody StatusRequest statusRequest){
//        Users users = userService.findUserById(userId);
//        if (users.getListRoles().size()==3){
//            return ResponseEntity.ok("không thể cập nhật tài khoản này");
//
//        }else {
//            users.setUserStatus(statusRequest.isUserStatus());
//            return ResponseEntity.ok(userService.saveOrUpdate(users));
//        }
//    }

}
