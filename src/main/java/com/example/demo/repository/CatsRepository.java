package com.example.demo.repository;

import com.example.demo.entity.Cat;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatsRepository extends JpaRepository<Cat, UUID> {

    boolean existsByNameIgnoreCase(String name);

    List<Cat> findTop3ByNameContaining(String name);

    List<Cat> findByOwner(User user);

}