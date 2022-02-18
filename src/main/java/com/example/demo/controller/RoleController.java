package com.example.demo.controller;

import com.example.demo.entity.Cat;
import com.example.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/add")
    public void createRole(@RequestParam String roleName) {
        roleService.createRole(roleName);

    }


    @GetMapping("/getAllCatsByRoleName")
    public List<Cat> getAllCatsByRoleName(@RequestParam String roleName) {
        return roleService.getAllCatsByRoleName(roleName);
    }

}
