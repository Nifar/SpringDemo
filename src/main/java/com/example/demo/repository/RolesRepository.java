package com.example.demo.repository;

import com.example.demo.entity.Cat;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(String name);

    @Query("SELECT c FROM Cat c where :roleName in (select r.name FROM c.owner.roles r)")
    List<Cat> getAllCatsByRoleName(@Param("roleName") String roleName);


}
