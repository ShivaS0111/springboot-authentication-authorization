package biz.craftline.server.api.controller;

import biz.craftline.server.api.dto.UserRoleDTO;
import biz.craftline.server.api.response.APIResponse;
import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.model.User;
import biz.craftline.server.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;

import static biz.craftline.server.utils.network.NetworkUtilsKt.success;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }


    @GetMapping("/list")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/assignRole")
    public ResponseEntity<APIResponse<String>> assignRoleToUser(@RequestBody UserRoleDTO userRoleDTO) throws Exception {
        userService.assignRoleToUser(userRoleDTO.getUserId(), userRoleDTO.getRoleId());
        return success("Success");
    }

    @PostMapping("/removeRole")
    public ResponseEntity<APIResponse<String>> removeRole(@RequestBody UserRoleDTO userRoleDTO) throws Exception {
        userService.deleteRoleToUser(userRoleDTO.getUserId(), userRoleDTO.getRoleId());
        return success("Success");
    }
}
