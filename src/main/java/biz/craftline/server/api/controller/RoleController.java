package biz.craftline.server.api.controller;

import biz.craftline.server.api.dto.NewRoleDTO;
import biz.craftline.server.api.dto.UserRoleDTO;
import biz.craftline.server.api.response.APIResponse;
import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static biz.craftline.server.utils.network.NetworkUtilsKt.*;

@RequestMapping("/roles")
@RestController
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public ResponseEntity<APIResponse<List<Role>>> roles() {
        List<Role> roles = roleService.findAll();
        return success(roles);
    }


    @PostMapping("/add")
    public ResponseEntity<APIResponse<Role>> addRole(@RequestBody  NewRoleDTO role) {
        return success(roleService.addRole(role.getRole()));
    }


    @PostMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteRole(Role role) {
        roleService.makeInactiveRole(role);
        return success("success");
    }

}
