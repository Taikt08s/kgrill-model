package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String role);
}
