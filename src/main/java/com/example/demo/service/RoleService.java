package com.example.demo.service;

import com.example.demo.entity.Cat;
import com.example.demo.entity.Role;
import com.example.demo.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RolesRepository rolesRepository;

    public List<Cat> getAllCatsByRoleName(String roleName) {
        return rolesRepository.getAllCatsByRoleName(roleName);
    }


    @Transactional
    public void createRole(String roleName) {
        rolesRepository.save(new Role(roleName));
    }
}
