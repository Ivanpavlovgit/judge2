package com.example.judge2.repository;

import com.example.judge2.model.entity.Role;
import com.example.judge2.model.entity.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole (RoleNameEnum role);
}
